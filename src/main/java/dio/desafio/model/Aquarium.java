package dio.desafio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_aquarium")
public class Aquarium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iluminacao;
    private String substrato;
    private String co2;
    private String posicao;
    private Double phMinimo;
    private Double phMaximo;
    private Integer temperaturaMinima;
    private Integer temperaturaMaxima;

    public String getIluminacao() {
        return iluminacao;
    }

    public void setIluminacao(String iluminacao) {
        this.iluminacao = iluminacao;
    }

    public String getSubstrato() {
        return substrato;
    }

    public void setSubstrato(String substrato) {
        this.substrato = substrato;
    }

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    public Double getPhMinimo() {
        return phMinimo;
    }

    public void setPhMinimo(Double phMinimo) {
        this.phMinimo = phMinimo;
    }

    public Double getPhMaximo() {
        return phMaximo;
    }

    public void setPhMaximo(Double phMaximo) {
        this.phMaximo = phMaximo;
    }

    public Integer getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(Integer temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public Integer getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(Integer temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
