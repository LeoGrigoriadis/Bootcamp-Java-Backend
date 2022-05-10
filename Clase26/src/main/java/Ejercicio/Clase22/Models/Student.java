package Ejercicio.Clase22.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Range(min=10000000, max=99999999, message="El dni debe contar con 8 dígitos.")
    @Column(unique = true)
    private long dni;
    @NotEmpty(message = "El nombre es necesario.")
    private String firstname;
    @NotEmpty(message = "El apellido es necesario.")
    private String lastname;
    @NotEmpty(message = "El teléfono es necesario.")
    private String phNumber;
}
