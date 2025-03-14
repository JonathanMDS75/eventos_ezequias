package Sistema_para_controle_de_eventos.resources;

import Sistema_para_controle_de_eventos.dtos.ProdutoraDTO;
import Sistema_para_controle_de_eventos.services.ProdutoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtoras")
public class ProdutoraResource {

    private final ProdutoraService produtoraService;

    public ProdutoraResource(ProdutoraService produtoraService){this.produtoraService = produtoraService;}

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoraDTO> buscarProdutora(@PathVariable Long id){
        ProdutoraDTO produtoraDTO = produtoraService.buscarProdutora(id);
        return ResponseEntity.ok(produtoraDTO);
    }
    @GetMapping("/buscar")
    public ResponseEntity<ProdutoraDTO> buscarProdutora(@RequestParam String cpfCnpj){
        ProdutoraDTO produtoraDTO = produtoraService.buscarProdutora(Long.valueOf(cpfCnpj));
        return ResponseEntity.ok(produtoraDTO);
    }
    @PostMapping("/")
    public ResponseEntity<ProdutoraDTO> criarProdutora(@RequestBody ProdutoraDTO produtoraDTO){
        return ResponseEntity.ok(produtoraService.salvarProdutora(produtoraDTO));
    }
    @PutMapping()
    public ResponseEntity<ProdutoraDTO> atualizarProdutora(@RequestBody ProdutoraDTO produtoraDTO){
        return ResponseEntity.ok(produtoraService.salvarProdutora(produtoraDTO));
    }
    @DeleteMapping()
    public ResponseEntity<Void> deletarProdutora(@RequestBody ProdutoraDTO produtoraDTO){
        produtoraService.deletarProdutora(produtoraDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
