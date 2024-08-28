package ar.edu.utn.frc.tup.lciii.motorcyclesservice.repositories;

import ar.edu.utn.frc.tup.lciii.motorcyclesservice.entities.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MotorcycleRepository extends JpaRepository<Motorcycle, Integer> {

    Optional<List<Motorcycle>> findByUserId(Integer idUser);

}
