package ar.edu.utn.frc.tup.lciii.motorcyclesservice.services;

import ar.edu.utn.frc.tup.lciii.motorcyclesservice.entities.Motorcycle;

import java.util.List;

public interface IMotorcycleService {
    List<Motorcycle> getAll();
    Motorcycle getById(Integer id);

    Motorcycle save(Motorcycle motorcycle);

    List<Motorcycle> getByUserId(Integer id);
}
