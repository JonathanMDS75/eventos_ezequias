package Sistema_para_controle_de_eventos.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cidades")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;

    private String estado;

    public Cidade() {}

    public Cidade(String nome, String estado) {
        this.nome = nome;
        this.estado = estado;
    }




}
