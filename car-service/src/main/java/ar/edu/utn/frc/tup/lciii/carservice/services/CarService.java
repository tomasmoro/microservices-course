package ar.edu.utn.frc.tup.lciii.carservice.services;

import ar.edu.utn.frc.tup.lciii.carservice.entities.Car;
import ar.edu.utn.frc.tup.lciii.carservice.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getById(Integer id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getByUserId(Integer id) {
        return carRepository.findByUserId(id).get();
    }


}
