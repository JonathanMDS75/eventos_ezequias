package Sistema_para_controle_de_eventos.dtos;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ProdutoraDTO {
    private Long id;

    private String nome;

    private String cpfCnpj;

    public ProdutoraDTO(){}

}
