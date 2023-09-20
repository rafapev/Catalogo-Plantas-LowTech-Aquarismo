package dio.desafio.service.impl;

import dio.desafio.model.Plant;
import dio.desafio.repository.PlantRepository;
import dio.desafio.service.PlantService;
import dio.desafio.service.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class PlantServiceImpl implements PlantService {

    //private static final Long UNCHANGEABLE_PLANTA_ID = 1L;
    private final PlantRepository plantRepository;


    public PlantServiceImpl(PlantRepository plantRepository){
        this.plantRepository = plantRepository;
    }
    @Transactional
    public List<Plant> findAll(){
        return this.plantRepository.findAll();
    }
    @Transactional
    public Plant findById(Long id) {
        return this.plantRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Plant create(Plant plantToCreate) {
        if(plantRepository.existsByNome(plantToCreate.getNome())){
            throw new IllegalArgumentException("Essa planta já existe.");
        }
        return this.plantRepository.save(plantToCreate);
    }
    @Transactional
    public Plant update(Long id, Plant plantToUpdate){
        //this.validateChangeableId(id, "updated");
        Plant dbPlant = this.findById(id);
        /*if(!dbPlant.getId().equals(plantToUpdate.getId())){
            throw new BusinessException("Update IDs must be the same.");
        }*/

        dbPlant.setNome(plantToUpdate.getNome());
        dbPlant.setOrigem(plantToUpdate.getOrigem());
        //dbPlant.setAquario(plantToUpdate.getAquario());
        return this.plantRepository.save(dbPlant);

    }
    @Transactional
    public void delete(Long id){
        //this.validateChangeableId(id, "deleted");
        Plant dbPlant = this.findById(id);
        this.plantRepository.delete(dbPlant);
    }

   /* private void validateChangeableId(Long id, String operation){
        if(UNCHANGEABLE_PLANTA_ID.equals(id)){
            throw new BusinessException("User with ID %d cannot be %s".formatted(UNCHANGEABLE_PLANTA_ID, operation));
        }
    }*/
}
