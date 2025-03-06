package Sistema_para_controle_de_eventos.resources;

import Sistema_para_controle_de_eventos.dtos.CidadeDTO;
import Sistema_para_controle_de_eventos.services.CidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cidades")
public class CidadeResource {

    private final CidadeService cidadeService;


    public CidadeResource(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> buscarCidade(@PathVariable Long id) {
        CidadeDTO cidadeDTO = cidadeService.salvarCidade(new CidadeDTO(id));
        return ResponseEntity.ok(cidadeDTO);
    }
    @GetMapping("/buscar")
    public ResponseEntity<CidadeDTO> buscarCidade(@RequestParam String cep) {
        CidadeDTO cidadeDTO = cidadeService.salvarCidade(new CidadeDTO(cep));
        return ResponseEntity.ok(cidadeDTO);
    }
    @PostMapping("/")
    public ResponseEntity<CidadeDTO> criarCidade(@RequestBody CidadeDTO cidadeDTO) {
        return ResponseEntity.ok(cidadeService.salvarCidade(cidadeDTO));
    }
    @PutMapping()
    public ResponseEntity<CidadeDTO> atualizarCidade(@RequestBody CidadeDTO cidadeDTO) {
        return ResponseEntity.ok(cidadeService.salvarCidade(cidadeDTO));
    }
    @DeleteMapping()
    public ResponseEntity<Void> deletarCidade(@RequestBody CidadeDTO cidadeDTO) {
        cidadeService.deletarCidade(cidadeDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
