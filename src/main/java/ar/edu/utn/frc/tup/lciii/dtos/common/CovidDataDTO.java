package ar.edu.utn.frc.tup.lciii.dtos.common;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CovidDataDTO {
    private String nombreEstado;
    private String sigla;
    private LocalDate fecha;
    private Integer totalCasos;
    private Integer positivos;
    private Integer hospitalizados;

}
