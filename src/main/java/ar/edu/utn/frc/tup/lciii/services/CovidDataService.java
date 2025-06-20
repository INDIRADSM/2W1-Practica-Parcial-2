package ar.edu.utn.frc.tup.lciii.services;
import ar.edu.utn.frc.tup.lciii.dtos.common.CovidDataDTO;
import ar.edu.utn.frc.tup.lciii.Entity.CovidData;
import ar.edu.utn.frc.tup.lciii.Repository.CovidDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CovidDataService {
    private final CovidDataRepository repository;
    private final ModelMapper mapper;

    public CovidDataService(CovidDataRepository repository,@Qualifier("modelMapper")  ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CovidDataDTO> getAll() {
        return repository.findAll().stream()
                .map(data -> mapper.map(data, CovidDataDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<Double> calcularPorcentaje(String estado, LocalDate fecha) {
        return repository.findBySiglaAndFecha(estado, fecha)
                .map(data -> {
                    if (data.getTotalCasos() == null || data.getTotalCasos() == 0) {
                        return 0.0;
                    }
                    return (data.getPositivos() * 100.0) / data.getTotalCasos();
                });
    }

    public CovidDataDTO guardar(String estado, LocalDate fecha, CovidDataDTO dto) {
        dto.setSigla(estado);
        dto.setFecha(fecha);
        CovidData entity = mapper.map(dto, CovidData.class);
        CovidData saved = repository.save(entity);
        return mapper.map(saved, CovidDataDTO.class);
    }

}
