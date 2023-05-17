package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Table(name = "ClientTbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private long id_no;
    private String address;
    private int room_no;
    private String entranceDate;
    private String outDate;
    private float paid_money;
    private String phone;
}
