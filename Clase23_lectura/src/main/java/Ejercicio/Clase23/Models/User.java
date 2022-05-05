package Ejercicio.Clase23.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class User {

    private long id;
    @NotEmpty(message = "El nombre es necesario.")
    private String name;
    @NotEmpty(message = "El apellido es necesario.")
    private String lastName;
    @Positive(message = "El dni no puede ser un valor negativo.")
    @Range(min=10000000, max=99999999, message="El dni debe contar con 8 dígitos.")
    private long dni;
    @NotEmpty(message = "El teléfono es necesario.")
    private String phNumber;
}
