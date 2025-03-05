package Sistema_para_controle_de_eventos.resources;

import Sistema_para_controle_de_eventos.dtos.UsuarioDTO;
import Sistema_para_controle_de_eventos.models.Usuario;
import Sistema_para_controle_de_eventos.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO>buscarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuario(id);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }
    @GetMapping("/buscar")
    public ResponseEntity<UsuarioDTO> buscarUsuario(@RequestParam String email) {
        Usuario usuario = usuarioService.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }

    @PostMapping("/")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));
    }
    @PutMapping()
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.atualizarUsuario(usuarioDTO));
    }
    @DeleteMapping()
    public ResponseEntity<Void> deletarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.deletarUsuario(usuarioDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
