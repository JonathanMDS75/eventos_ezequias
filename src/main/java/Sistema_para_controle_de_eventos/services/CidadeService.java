package Sistema_para_controle_de_eventos.services;

import Sistema_para_controle_de_eventos.dtos.CidadeDTO;
import Sistema_para_controle_de_eventos.models.Cidade;
import Sistema_para_controle_de_eventos.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {
    @Autowired

    private CidadeRepository cidadeRepository;

    public CidadeDTO salvarCidade(CidadeDTO cidadeDTO) {
        Cidade cidade = converterCidadeDTOParaCidade(cidadeDTO);
        cidade = cidadeRepository.save(cidade);
        return converterCidadeParaCidadeDTO(cidade);
    }

    private CidadeDTO converterCidadeParaCidadeDTO(Cidade cidade) {
        CidadeDTO cidadeDTO = new CidadeDTO();
        cidadeDTO.setId(cidade.getId());
        cidadeDTO.setNome(cidade.getNome());
        cidadeDTO.setEstado(cidade.getEstado());
        return cidadeDTO;
    }

    public Cidade converterCidadeDTOParaCidade(CidadeDTO cidadeDTO) {
        Cidade cidade = new Cidade();
        cidade.setId(cidadeDTO.getId());
        cidade.setNome(cidadeDTO.getNome());
        cidade.setEstado(cidadeDTO.getEstado());
        return cidade;
    }
}
