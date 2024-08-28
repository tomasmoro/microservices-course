package ar.edu.utn.frc.tup.lciii.userservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Motorcycle {
    private String description;
    private String brand;
    private String yearMade ;
    private Integer userId;
}
