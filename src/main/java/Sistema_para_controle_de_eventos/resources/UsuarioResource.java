package Sistema_para_controle_de_eventos.resources;

import Sistema_para_controle_de_eventos.dtos.UsuarioDTO;
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

    @GetMapping("/")
    public String getUsuarios() {
        return "testar retorno dos Usuarios";
    }
    @PostMapping("/")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));
    }
}
