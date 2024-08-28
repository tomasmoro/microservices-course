package ar.edu.utn.frc.tup.lciii.userservice.repositories;

import ar.edu.utn.frc.tup.lciii.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
