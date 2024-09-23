package com.example.cabinetdentistrybackend.controller;

import com.example.cabinetdentistrybackend.model.Appointment;
import com.example.cabinetdentistrybackend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appointment);
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createOrUpdateAppointment(appointment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointmentDetails) {
        Appointment existingAppointment = appointmentService.getAppointmentById(id);
        if (existingAppointment == null) {
            return ResponseEntity.notFound().build();
        }
        appointmentDetails.setId(id);
        return ResponseEntity.ok(appointmentService.createOrUpdateAppointment(appointmentDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        Appointment existingAppointment = appointmentService.getAppointmentById(id);
        if (existingAppointment == null) {
            return ResponseEntity.notFound().build();
        }
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsByPatientId(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsByPatientId(patientId);
    }

}
