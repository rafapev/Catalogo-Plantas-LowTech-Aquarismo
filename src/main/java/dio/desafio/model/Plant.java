package dio.desafio.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.ManyToAny;


@Entity(name = "tb_plant")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String origem;
    private String crescimento;
    private Integer alturaMaximaEmCm;
    @OneToOne(cascade = CascadeType.ALL)
    private Aquarium aquarium;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aquarium getAquario() {
        return aquarium;
    }

    public void setAquario(Aquarium aquarium) {
        this.aquarium = aquarium;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getCrescimento() {
        return crescimento;
    }

    public void setCrescimento(String crescimento) {
        this.crescimento = crescimento;
    }

    public Integer getAlturaMaximaEmCm() {
        return alturaMaximaEmCm;
    }

    public void setAlturaMaximaEmCm(Integer alturaMaximaEmCm) {
        this.alturaMaximaEmCm = alturaMaximaEmCm;
    }

}
