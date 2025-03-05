package Sistema_para_controle_de_eventos.dtos;

import lombok.Data;

@Data
public class CidadeDTO {
    
    private Long id;

    private String nome;

    private String estado;
    
    public CidadeDTO() {}

}
