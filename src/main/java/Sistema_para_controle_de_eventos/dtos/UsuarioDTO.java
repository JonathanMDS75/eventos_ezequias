package Sistema_para_controle_de_eventos.dtos;

import Sistema_para_controle_de_eventos.models.Usuario;
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

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.cpf = usuario.getCpf();
        this.dataNascimento = usuario.getDataNascimento();
        this.perfil = usuario.getPerfil();
        this.isVerificado = usuario.getIsVerificado();
    }
}
