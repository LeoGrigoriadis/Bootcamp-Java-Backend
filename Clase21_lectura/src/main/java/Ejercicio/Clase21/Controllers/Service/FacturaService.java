package Ejercicio.Clase21.Controllers.Service;

import Ejercicio.Clase21.Controllers.Repository.FacturaRepository;
import Ejercicio.Clase21.Models.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FacturaService {
    @Autowired
    FacturaRepository fr;

    public ArrayList<Factura> getAll() {
        return (ArrayList<Factura>) fr.findAll();
    }

    public Factura getHighest(){
        return fr.findByMonto();
    }

    public ArrayList<Factura> getByDni(long dni){
        return fr.findByDni(dni);
    }

}
