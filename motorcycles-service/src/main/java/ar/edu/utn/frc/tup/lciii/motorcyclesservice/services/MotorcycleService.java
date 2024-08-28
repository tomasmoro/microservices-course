package ar.edu.utn.frc.tup.lciii.motorcyclesservice.services;

import ar.edu.utn.frc.tup.lciii.motorcyclesservice.entities.Motorcycle;
import ar.edu.utn.frc.tup.lciii.motorcyclesservice.repositories.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorcycleService implements IMotorcycleService {

    @Autowired
    private MotorcycleRepository motorcycleRepository;

    @Override
    public List<Motorcycle> getAll() {
        return motorcycleRepository.findAll();
    }

    @Override
    public Motorcycle getById(Integer id) {
        return motorcycleRepository.findById(id).orElse(null);
    }

    @Override
    public Motorcycle save(Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    @Override
    public List<Motorcycle> getByUserId(Integer id) {
        return motorcycleRepository.findByUserId(id).get();
    }


}
