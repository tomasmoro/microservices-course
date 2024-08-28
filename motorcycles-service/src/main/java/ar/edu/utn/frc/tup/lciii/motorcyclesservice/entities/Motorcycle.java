package ar.edu.utn.frc.tup.lciii.motorcyclesservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "motorcycles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private String brand;
    private String yearMade;
    private Integer userId;
}
