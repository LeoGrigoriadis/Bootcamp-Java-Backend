package Ejercicio.Clase21.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(nullable = false)
    private long dni;
    @NotEmpty
    @Column(nullable = false)
    private String first_name;
    @NotEmpty
    @Column(nullable = false)
    private String last_name;
    @NotEmpty
    @Column(nullable = false)
    private String address;
    @NotEmpty
    @Column
    private String description;
}