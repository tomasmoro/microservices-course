package ar.edu.utn.frc.tup.lciii.userservice.feignclients;

import ar.edu.utn.frc.tup.lciii.userservice.models.Car;
import ar.edu.utn.frc.tup.lciii.userservice.models.Motorcycle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "motorcycle-service", url = "http://localhost:8080")

public interface MotorcycleFeignClient {
    @RequestMapping(value = "/motorcycle", method = RequestMethod.POST)
    public Motorcycle save(@RequestBody Motorcycle car);

}
