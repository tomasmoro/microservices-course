package ar.edu.utn.frc.tup.lciii.userservice.services;

import ar.edu.utn.frc.tup.lciii.userservice.entities.User;
import ar.edu.utn.frc.tup.lciii.userservice.models.Car;
import ar.edu.utn.frc.tup.lciii.userservice.models.Motorcycle;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    List<Car> getCars(Integer userId);
    List<Motorcycle> getMotorcycles(Integer userId);
    User getById(Integer id);

    User save(User user);
    Motorcycle saveMotorcycle(Motorcycle motorcycle, Integer userId);
    Car saveCar(Car car, Integer userId);
}
