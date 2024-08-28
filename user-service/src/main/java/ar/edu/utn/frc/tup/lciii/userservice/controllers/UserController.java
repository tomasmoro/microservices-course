package ar.edu.utn.frc.tup.lciii.userservice.controllers;


import ar.edu.utn.frc.tup.lciii.userservice.entities.User;
import ar.edu.utn.frc.tup.lciii.userservice.models.Car;
import ar.edu.utn.frc.tup.lciii.userservice.models.Motorcycle;
import ar.edu.utn.frc.tup.lciii.userservice.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.getAll();
        if (users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id" )Integer id){
        User user = userService.getById(id);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
    @GetMapping("/car/{id}")
    public ResponseEntity<List<Car>> getCarsByUserId(@PathVariable("id" )Integer id){
        List<Car> cars = userService.getCars(id);
        if (cars == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cars);
    }    @GetMapping("/motorcycle/{id}")
    public ResponseEntity<List<Motorcycle>> getMotorcyclesByUserId(@PathVariable("id" )Integer id){
        List<Motorcycle> motorcycles = userService.getMotorcycles(id);
        if (motorcycles == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motorcycles);
    }
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User userResponse = userService.save(user);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/car/{userId}")
    public ResponseEntity<Car> saveCar(@RequestBody Car car, @PathVariable("userId") Integer userId){
        Car savedCar = userService.saveCar(car,userId);
        return ResponseEntity.ok(savedCar);
    }

    @PostMapping("/motorcycle/{userId}")
    public ResponseEntity<Motorcycle> saveMotorcycle(@RequestBody Motorcycle motorcycle, @PathVariable("userId") Integer userId){
        Motorcycle motorcycleResponse = userService.saveMotorcycle(motorcycle,userId);
        return ResponseEntity.ok(motorcycleResponse);
    }

}
