package Sistema_para_controle_de_eventos.services;

import Sistema_para_controle_de_eventos.dtos.UsuarioDTO;
import Sistema_para_controle_de_eventos.models.Usuario;
import Sistema_para_controle_de_eventos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
