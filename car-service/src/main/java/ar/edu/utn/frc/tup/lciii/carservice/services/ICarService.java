package ar.edu.utn.frc.tup.lciii.carservice.services;


import ar.edu.utn.frc.tup.lciii.carservice.entities.Car;

import java.util.List;

public interface ICarService {
    List<Car> getAll();
    Car getById(Integer id);

    Car save(Car car);

    List<Car> getByUserId(Integer id);
}
