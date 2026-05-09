package main.java.com.piedrazul.appointmentservice.service;

import com.piedrazul.appointmentservice.entity.Appointment;
import com.piedrazul.appointmentservice.repository.AppointmentRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE_NAME = "appointment-exchange";

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment createAppointment(Appointment appointment) {
        Appointment saved = appointmentRepository.save(appointment);
        // Enviar mensaje asincrónico
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "appointment.created", saved);
        return saved;
    }

    public Appointment updateAppointment(Long id, Appointment appointmentDetails) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow();
        appointment.setCitizenshipCardPatient(appointmentDetails.getCitizenshipCardPatient());
        appointment.setPhoneNumberPatient(appointmentDetails.getPhoneNumberPatient());
        appointment.setMedicalStaffId(appointmentDetails.getMedicalStaffId());
        appointment.setDateAndTime(appointmentDetails.getDateAndTime());
        appointment.setAttentionType(appointmentDetails.getAttentionType());
        Appointment updated = appointmentRepository.save(appointment);
        // Enviar mensaje asincrónico
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "appointment.updated", updated);
        return updated;
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
        // Enviar mensaje asincrónico
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "appointment.deleted", id);
    }
}