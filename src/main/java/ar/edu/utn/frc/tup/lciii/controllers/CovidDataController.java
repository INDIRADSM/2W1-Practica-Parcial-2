package ar.edu.utn.frc.tup.lciii.controllers;
import ar.edu.utn.frc.tup.lciii.dtos.common.CovidDataDTO;
import ar.edu.utn.frc.tup.lciii.services.CovidDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/covid")
public class CovidDataController {
    private final CovidDataService service;

    public CovidDataController(CovidDataService service) {
        this.service = service;
    }

    // GET /v1/covid/
    @Operation(summary = "Listar todos los registros COVID por estado")
    @GetMapping
    public ResponseEntity<List<CovidDataDTO>> getAllData() {
        return ResponseEntity.ok(service.getAll());
    }

    // GET /v1/covid/{estado}/{fecha}
    @Operation(summary = "Obtener el porcentaje de casos positivos para un estado y fecha")
    @GetMapping("/{estado}/{fecha}")
    public ResponseEntity<Double> getPositivityRate(
            @PathVariable String estado,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

        Optional<Double> porcentaje = service.calcularPorcentaje(estado, fecha);
        return porcentaje.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /v1/covid/{estado}/{fecha}
    @Operation(summary = "Guardar datos COVID para un estado y fecha")
    @PostMapping("/{estado}/{fecha}")
    public ResponseEntity<CovidDataDTO> saveCovidData(
            @PathVariable String estado,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
            @RequestBody CovidDataDTO dto) {

        CovidDataDTO saved = service.guardar(estado, fecha, dto);
        return ResponseEntity.ok(saved);
    }
}
