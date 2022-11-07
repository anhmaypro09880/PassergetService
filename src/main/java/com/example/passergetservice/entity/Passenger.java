package com.example.passergetservice.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Passenger")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Passenger implements Serializable {
    @Id

    @Column(name = "p_id")
    private int passId;
    private String name;
    private String address;
}
