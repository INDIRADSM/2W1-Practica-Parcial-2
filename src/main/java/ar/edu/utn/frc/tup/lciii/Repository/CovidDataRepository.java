package ar.edu.utn.frc.tup.lciii.Repository;
import ar.edu.utn.frc.tup.lciii.Entity.CovidData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;
public interface CovidDataRepository extends JpaRepository<CovidData, Long>{
    Optional<CovidData> findBySiglaAndFecha(String sigla, LocalDate fecha);
    List<CovidData> findBySigla(String sigla);

}
