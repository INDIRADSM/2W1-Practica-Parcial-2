package ar.edu.utn.frc.tup.lciii.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class CovidData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreEstado;
    private String sigla;
    private LocalDate fecha;
    private Integer totalCasos;
    private Integer positivos;
    private Integer hospitalizados;
}
