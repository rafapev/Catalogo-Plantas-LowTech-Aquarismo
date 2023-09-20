package dio.desafio.controller.dto;

import dio.desafio.model.Aquarium;

public record AquariumDto(
        Long id,
        String iluminacao,
        String substrato,
        String co2,
        String posicao,
        Double phMinimo,
        Double phMaximo,
        Integer temperaturaMinima,
        Integer temperaturaMaxima) {

        public AquariumDto(Aquarium model) {
            this(
                    model.getId(),
                    model.getIluminacao(),
                    model.getSubstrato(),
                    model.getCo2(),
                    model.getPosicao(),
                    model.getPhMinimo(),
                    model.getPhMaximo(),
                    model.getTemperaturaMinima(),
                    model.getTemperaturaMaxima()
            );
        }

        public Aquarium toModel(){
            Aquarium model = new Aquarium();
            model.setId(this.id);
            model.setIluminacao(this.iluminacao);
            model.setSubstrato(this.substrato);
            model.setCo2(this.co2);
            model.setPosicao(this.posicao);
            model.setPhMinimo(this.phMinimo);
            model.setPhMaximo(this.phMaximo);
            model.setTemperaturaMinima(this.temperaturaMinima);
            model.setTemperaturaMaxima(this.temperaturaMaxima);
            return model;
        }
}













