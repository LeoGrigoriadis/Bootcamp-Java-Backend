package main.Clase27_lectura.Controller;

import main.Clase27_lectura.Model.Car;
import main.Clase27_lectura.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarService cs;

    @GetMapping("/free")
    public ResponseEntity<Object> getAllFree(){
        try{
            Car car=cs.findAll().get(0);
            if(car!=null) return ResponseEntity.status(200).body(car);
            return ResponseEntity.status(404).body("Not Found");
        }catch (Exception e){
            return ResponseEntity.status(400).body("Bad Request");
        }
    }
    @GetMapping("/private")
    public ResponseEntity<Object> getAllPrivate(){
        try{
            ArrayList<Car> cars=cs.findAll();
            if(!cars.isEmpty()) return ResponseEntity.status(200).body(cars);
            return ResponseEntity.status(404).body("Not Found");
        }catch (Exception e){
            return ResponseEntity.status(400).body("Bad Request");
        }
    }
    @GetMapping("/private/date")
    public ResponseEntity<Object> getByDate(@RequestBody HashMap<String, Date> dates){
        try{
            ArrayList<Car> cars=cs.findByDate(dates);
            if(!cars.isEmpty()) return ResponseEntity.status(200).body(cars);
            return ResponseEntity.status(404).body("Not Found");
        }catch (Exception e){
            return ResponseEntity.status(400).body("Bad Request");
        }
    }
}
