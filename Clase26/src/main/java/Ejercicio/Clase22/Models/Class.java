package Ejercicio.Clase22.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;
    @NotEmpty(message = "El nombre es necesario.")
    private String name;

    public long getCode() {
        return code;
    }
}
