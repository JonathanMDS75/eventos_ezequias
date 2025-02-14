package Sistema_para_controle_de_eventos.dtos;

import lombok.Data;

import java.util.Date;
@Data
public class UsuarioDTO {

    private long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private Date dataNascimento;
    private String perfil;
    private Boolean isVerificado;


}
