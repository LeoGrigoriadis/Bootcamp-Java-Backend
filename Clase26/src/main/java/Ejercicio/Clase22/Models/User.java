package Ejercicio.Clase22.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "El username es necesario.")
    private String username;
    @NotEmpty(message = "La contraseña es necesario.")
    private String password;
    @NotEmpty(message = "El nombre es necesario.")
    private String name;
    @NotEmpty(message = "El email es necesario.")
    private String email;
}
