package com.example.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Controller;

import java.util.Date;
@Entity
@Table(name = "Medecine_Table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medecine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String medecine_name;
    private String medecine_number;
    private float medecine_price;
    private String manfactured_date;
    private String expired_date;


}
