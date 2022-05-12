package main.Clase27_lectura.Controller;

import main.Clase27_lectura.Model.Car;
import main.Clase27_lectura.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarService cs;

    @GetMapping
    public ResponseEntity getAll(){
        try{
            ArrayList<Car> cars=cs.findAll();
            if(!cars.isEmpty()) return ResponseEntity.status(200).body(cars);
            return ResponseEntity.status(400).body("Bad Request");
        }catch (Exception e){
            return ResponseEntity.status(404).body("Not Found");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id){
        try{
            Car car=cs.findById(id);
            if(car!=null) return ResponseEntity.status(200).body(car);
            return ResponseEntity.status(400).body("Bad Request");
        }catch (Exception e){
            return ResponseEntity.status(404).body("Not Found");
        }
    }

}
