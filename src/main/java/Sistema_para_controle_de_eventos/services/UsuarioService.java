package Sistema_para_controle_de_eventos.services;

import Sistema_para_controle_de_eventos.dtos.UsuarioDTO;
import Sistema_para_controle_de_eventos.models.Usuario;
import Sistema_para_controle_de_eventos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        return new UsuarioDTO(usuarioRepository.save(usuario));
    }

    public Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }
    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {
        if (isNull(usuarioDTO.getId())) {
            throw new IllegalArgumentException("campo Id não informado");
        }
        Usuario usuario = usuarioRepository.findById(usuarioDTO.getId()).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        usuario = new Usuario(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
