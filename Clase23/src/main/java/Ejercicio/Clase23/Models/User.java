package Ejercicio.Clase23.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class User {

    private long id;
    private String name;
    private String lastName;
    private long dni;
    private String phNumber;
}
