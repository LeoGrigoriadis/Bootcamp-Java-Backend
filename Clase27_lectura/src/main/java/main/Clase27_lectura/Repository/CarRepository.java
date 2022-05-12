package main.Clase27_lectura.Repository;

import main.Clase27_lectura.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    public Car findById(long id);
}
