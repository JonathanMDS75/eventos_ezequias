package Sistema_para_controle_de_eventos.models;

import Sistema_para_controle_de_eventos.dtos.UsuarioDTO;
import Sistema_para_controle_de_eventos.enums.Perfil;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    @Column(unique = true)
    private String cpf;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    private List<Perfil> perfis;

    @Column(name = "is_verificado")
    private Boolean isVerificado;

    public Usuario() {}
    public Usuario(String nome, String email, String senha, String cpf, Date dataNascimento, List<Perfil> perfis, Boolean isVerificado) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.perfis = perfis;
        this.isVerificado = isVerificado;
    }
    //para salvar objeto lá do usuarioService
    public Usuario(UsuarioDTO usuarioDTO) {
        this.nome = usuarioDTO.getNome();
        this.email = usuarioDTO.getEmail();
        this.senha = usuarioDTO.getSenha();
        this.cpf = usuarioDTO.getCpf();
        this.dataNascimento = usuarioDTO.getDataNascimento();
        this.perfis = usuarioDTO.getPerfis();
        this.isVerificado = usuarioDTO.getIsVerificado();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
