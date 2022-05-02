package Ejercicio.Clase19_lectura.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class User{
    private long dni;
    private String firstName;
    private String lastName;

}
