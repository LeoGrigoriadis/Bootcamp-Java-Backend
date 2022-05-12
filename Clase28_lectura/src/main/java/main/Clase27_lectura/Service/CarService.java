package main.Clase27_lectura.Service;

import main.Clase27_lectura.Model.Car;
import main.Clase27_lectura.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CarService {
    @Autowired
    CarRepository cr;

    public ArrayList<Car> findAll() { return (ArrayList<Car>) cr.findAll(); }

    public ArrayList<Car> findByDate(HashMap<String, Date> dates) {
        Date date1=dates.get("date1");
        Date date2=dates.get("date2");
        return cr.findByDate(date1.toString(),date2.toString());
    }
}
