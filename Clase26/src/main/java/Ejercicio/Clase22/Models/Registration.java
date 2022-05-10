package Ejercicio.Clase22.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "codeClass")
    private Class codeClass;
    @ManyToOne
    @JoinColumn(name = "idStudent")
    private Student idStudent;
}
