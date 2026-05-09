package main.java.com.piedrazul.appointmentservice.repository;

import com.piedrazul.appointmentservice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByCitizenshipCardPatient(Long citizenshipCard);
}