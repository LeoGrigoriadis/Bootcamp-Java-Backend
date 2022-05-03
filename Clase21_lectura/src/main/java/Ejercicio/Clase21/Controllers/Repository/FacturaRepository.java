package Ejercicio.Clase21.Controllers.Repository;

import Ejercicio.Clase21.Models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    ArrayList<Factura> findAll();

    @Query(value="SELECT *  FROM facturas  WHERE monto=(\n" +
            "    SELECT max(monto) FROM facturas\n" +
            ")", nativeQuery = true)
    Factura findByMonto();

    ArrayList<Factura> findByDni(long dni);

}
