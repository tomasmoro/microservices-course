package ar.edu.utn.frc.tup.lciii.userservice.services;

import ar.edu.utn.frc.tup.lciii.userservice.entities.User;
import ar.edu.utn.frc.tup.lciii.userservice.feignclients.CarFeignClient;
import ar.edu.utn.frc.tup.lciii.userservice.feignclients.MotorcycleFeignClient;
import ar.edu.utn.frc.tup.lciii.userservice.models.Car;
import ar.edu.utn.frc.tup.lciii.userservice.models.Motorcycle;
import ar.edu.utn.frc.tup.lciii.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CarFeignClient carFeignClient;
    @Autowired
    private MotorcycleFeignClient motorcycleFeignClient;

    @Override
    public List<Car> getCars(Integer userId){
        return restTemplate.getForObject("http://localhost:8082/cars/user/"+userId, List.class);
    }

    @Override
    public List<Motorcycle> getMotorcycles(Integer userId){
        return restTemplate.getForObject("http://localhost:8080/motorcycle/user/"+userId, List.class);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Motorcycle saveMotorcycle(Motorcycle motorcycle, Integer userId) {
        User user = getById(userId);
        if (user == null){
            return null;
        }
        motorcycle.setUserId(userId);
        return motorcycleFeignClient.save(motorcycle);
    }

    @Override
    public Car saveCar(Car car, Integer userId) {
        User user = getById(userId);
        if (user == null) {
            return null;
        }

        car.setUserId(userId);
        return carFeignClient.save(car);
    }
}
