package com.example.cabinetdentistrybackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Setter
@Getter
public class Appointment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private Date date; //il faut etre tt la date

        @Column(nullable = false)
        private String time;



        @ManyToOne
        @JoinColumn(name = "patient_id", nullable = false)
        @JsonBackReference
        private Patient patient;



        private String treatment;

        @ElementCollection
        private List<String> dentNum;

        private String medicament;
        private String status;

        // Constructeur par défaut nécessaire pour JPA
        public Appointment() {
        }



}
