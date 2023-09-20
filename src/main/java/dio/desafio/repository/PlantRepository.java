package dio.desafio.repository;

import dio.desafio.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

    boolean existsByNome(String nome);

}
