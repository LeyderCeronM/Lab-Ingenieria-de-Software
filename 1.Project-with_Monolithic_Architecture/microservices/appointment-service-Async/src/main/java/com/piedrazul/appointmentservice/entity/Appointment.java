package main.java.com.piedrazul.appointmentservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long citizenshipCardPatient;
    private String phoneNumberPatient;
    private Long medicalStaffId;
    private LocalDateTime dateAndTime;

    @Enumerated(EnumType.STRING)
    private AttentionType attentionType;
}