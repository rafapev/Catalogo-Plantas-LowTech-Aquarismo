package dio.desafio.controller.dto;

import dio.desafio.model.Plant;

import static java.util.Optional.ofNullable;

public record PlantDto(
        Long id,
        String nome,
        String origem,
        String crescimento,
        Integer alturaMaximaEmCm,
        AquariumDto aquario) {

    public PlantDto(Plant model){
        this(
                model.getId(),
                model.getNome(),
                model.getOrigem(),
                model.getCrescimento(),
                model.getAlturaMaximaEmCm(),
                ofNullable(model.getAquario()).map(AquariumDto::new).orElseThrow(null)

        );
    }

    public Plant toModel(){
        Plant model = new Plant();
        model.setId(this.id);
        model.setNome(this.nome);
        model.setOrigem(this.origem);
        model.setCrescimento(this.crescimento);
        model.setAlturaMaximaEmCm(this.alturaMaximaEmCm);
        model.setAquario(ofNullable(this.aquario).map(AquariumDto::toModel).orElse(null));
        return model;
    }

}


