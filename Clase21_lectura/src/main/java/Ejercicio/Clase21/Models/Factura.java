package Ejercicio.Clase21.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "facturas")
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @NotEmpty
    private String nombre;
    @Column
    @NotNull
    private long dni;
    @Temporal(value = TemporalType.DATE)
    @Column
    private Date fecha;
    @NotEmpty
    @Column
    private double monto;
}
