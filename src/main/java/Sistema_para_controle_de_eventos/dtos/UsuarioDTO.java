package Sistema_para_controle_de_eventos.dtos;

import Sistema_para_controle_de_eventos.enums.Perfil;
import Sistema_para_controle_de_eventos.models.Usuario;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UsuarioDTO {

    private long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private Date dataNascimento;
    private List<Perfil> perfis;
    private Boolean isVerificado;

    public UsuarioDTO() {}

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.cpf = usuario.getCpf();
        this.dataNascimento = usuario.getDataNascimento();
        this.perfis = usuario.getPerfis();
        this.isVerificado = usuario.getIsVerificado();
    }
}
