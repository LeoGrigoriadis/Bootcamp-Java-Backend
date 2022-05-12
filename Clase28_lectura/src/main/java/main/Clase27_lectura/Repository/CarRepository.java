package main.Clase27_lectura.Repository;

import main.Clase27_lectura.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findById(long id);
    @Query(value = "SELECT * from car where date between :date1 and :date2", nativeQuery = true)
    ArrayList<Car> findByDate(@Param("date1") String date1,@Param("date2") String date2);
}
