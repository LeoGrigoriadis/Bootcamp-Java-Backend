package Ejercicio.Clase19_lectura.Model.Concrets;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users")
@Entity
public class UserSQL {
    @Id
    private long dni;
    @Column()
    private String firstName;
    @Column()
    private String lastName;
}
