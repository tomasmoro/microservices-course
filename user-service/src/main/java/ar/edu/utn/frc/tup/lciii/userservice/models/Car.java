package ar.edu.utn.frc.tup.lciii.userservice.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String description;
    private String brand;
    private String yearMade;
    private Integer userId;
}
