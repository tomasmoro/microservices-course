package ar.edu.utn.frc.tup.lciii.userservice.feignclients;

import ar.edu.utn.frc.tup.lciii.userservice.models.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "car-service", url = "http://localhost:8082")
public interface CarFeignClient {
     @RequestMapping(value = "/cars", method = RequestMethod.POST)
     public Car save(@RequestBody Car car);
}
