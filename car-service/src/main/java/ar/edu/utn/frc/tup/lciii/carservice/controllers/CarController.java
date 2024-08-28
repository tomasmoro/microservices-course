package ar.edu.utn.frc.tup.lciii.carservice.controllers;


import ar.edu.utn.frc.tup.lciii.carservice.entities.Car;
import ar.edu.utn.frc.tup.lciii.carservice.services.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private ICarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAll(){
        List<Car> cars = carService.getAll();
        if (cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable("id" )Integer id){
        Car car = carService.getById(id);
        if (car == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Car>> getByUserId(@PathVariable("id" )Integer id){
        List<Car> cars = carService.getByUserId(id);
        if (cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }
    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car){
        Car carResponse = carService.save(car);
        return ResponseEntity.ok(carResponse);
    }

}
