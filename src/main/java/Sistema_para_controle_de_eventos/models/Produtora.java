package Sistema_para_controle_de_eventos.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "produtora")
public class Produtora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Getter
    private String nome;

    @Setter
    @Getter
    @Column(name = "cpf_cnpj", unique = true)
    private String cpfCnpj;

    public Long getId(){return id;}

    public void setId(Long id){this.id = id;}

    @Override
    public boolean equals(Object o) {
        Produtora produtora = (Produtora) o;
        return Objects.equals(id, produtora.id) && Objects.equals(nome, produtora.nome) && Objects.equals(cpfCnpj, produtora.cpfCnpj);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpfCnpj);
    }
}
