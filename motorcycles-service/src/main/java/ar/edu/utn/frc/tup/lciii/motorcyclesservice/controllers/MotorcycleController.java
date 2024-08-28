package ar.edu.utn.frc.tup.lciii.motorcyclesservice.controllers;



import ar.edu.utn.frc.tup.lciii.motorcyclesservice.entities.Motorcycle;
import ar.edu.utn.frc.tup.lciii.motorcyclesservice.services.IMotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorcycle")
public class MotorcycleController {

    @Autowired
    private IMotorcycleService motorcycleService;

    @GetMapping
    public ResponseEntity<List<Motorcycle>> getAll(){
        List<Motorcycle> motorcycles = motorcycleService.getAll();
        if (motorcycles.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motorcycles);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Motorcycle> getById(@PathVariable("id" )Integer id){
        Motorcycle motorcycle = motorcycleService.getById(id);
        if (motorcycle == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motorcycle);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Motorcycle>> getByUserId(@PathVariable("id" )Integer id){
        List<Motorcycle> motorcycles = motorcycleService.getByUserId(id);
        if (motorcycles.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motorcycles);
    }
    @PostMapping
    public ResponseEntity<Motorcycle> save(@RequestBody Motorcycle motorcycle){
        Motorcycle motorcycleResponse = motorcycleService.save(motorcycle);
        return ResponseEntity.ok(motorcycleResponse);
    }

}
