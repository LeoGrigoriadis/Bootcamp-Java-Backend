package main.Clase27_lectura.Service;

import main.Clase27_lectura.Model.Car;
import main.Clase27_lectura.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarService {
    @Autowired
    CarRepository cr;

    public ArrayList<Car> findAll() { return (ArrayList<Car>) cr.findAll(); }

    public Car findById(long id) { return cr.findById(id); }
}
