package Sistema_para_controle_de_eventos.services;

import Sistema_para_controle_de_eventos.dtos.ProdutoraDTO;
import Sistema_para_controle_de_eventos.models.Produtora;
import Sistema_para_controle_de_eventos.repositories.ProdutoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoraService {
    @Autowired

    private ProdutoraRepository produtoraRepository;

    public ProdutoraDTO salvarProdutora(ProdutoraDTO produtoraDTO) {
        Produtora produtora = converterProdutoraDTOParaProdutora(produtoraDTO);
        produtora = produtoraRepository.save(produtora);
        return converterProdutoraParaProdutoraDTO(produtora);
    }

    private ProdutoraDTO converterProdutoraParaProdutoraDTO(Produtora produtora){
        ProdutoraDTO produtoraDTO = new ProdutoraDTO();
        produtoraDTO.setId(produtora.getId());
        produtoraDTO.setNome(produtora.getNome());
        produtoraDTO.setCpfCnpj(produtora.getCpfCnpj());
        return produtoraDTO;
    }

    public Produtora converterProdutoraDTOParaProdutora(ProdutoraDTO produtoraDTO){
        Produtora produtora = new Produtora();
        produtora.setId(produtoraDTO.getId());
        produtora.setNome(produtoraDTO.getNome());
        produtora.setCpfCnpj(produtoraDTO.getCpfCnpj());
        return produtora;
    }

    public ProdutoraDTO atualizarProdutora(ProdutoraDTO produtoraDTO){
        Produtora produtora = produtoraRepository.findById(produtoraDTO.getId()).orElseThrow(() ->
                new IllegalArgumentException("Produtora não encontrada"));
        produtora = converterProdutoraDTOParaProdutora(produtoraDTO);
        produtora = produtoraRepository.save(produtora);
        return converterProdutoraParaProdutoraDTO(produtora);
    }

    public ProdutoraDTO buscarProdutora(Long id){
       return converterProdutoraParaProdutoraDTO(produtoraRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Produtora não encontrada")));
    }

    public void deletarProdutora(Long id){
        produtoraRepository.deleteById(id);
    }
}
