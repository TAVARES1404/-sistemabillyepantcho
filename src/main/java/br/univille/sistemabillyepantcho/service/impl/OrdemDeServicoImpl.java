package br.univille.sistemabillyepantcho.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sistemabillyepantcho.dto.OrdemDeServicoDTO;
import br.univille.sistemabillyepantcho.entity.OrdemDeServico;
import br.univille.sistemabillyepantcho.mapper.OrdemDeServicoMapper;
import br.univille.sistemabillyepantcho.repository.OrdemDeServicoRepository;
import br.univille.sistemabillyepantcho.service.OrdemDeServicoService;

@Service
public class OrdemDeServicoImpl implements OrdemDeServicoService {

    @Autowired
    private OrdemDeServicoRepository repository;
    private VeiculoServiceImpl rs;
    private OrdemDeServicoMapper mapper = Mappers.getMapper(OrdemDeServicoMapper.class);

    @Override
    public List<OrdemDeServicoDTO> getAll() {
        return mapper.mapOrdemDeServico(repository.findAll());
    }

    @Override
    public OrdemDeServicoDTO save(OrdemDeServicoDTO ordemDeServico) {
        OrdemDeServico ordemDeServicoEntity = mapper.mapOrdemDeServicoDTO(ordemDeServico);
        repository.save(ordemDeServicoEntity);
        return mapper.mapOrdemDeServico(ordemDeServicoEntity);
    }

    @Override
    public OrdemDeServicoDTO buscarPeloId(long id) {
        Optional<OrdemDeServico> os = repository.findById(id);   
        if (os.isPresent()){
            OrdemDeServico ordemDeServicoEntitty = os.get();
            return mapper.mapOrdemDeServico(ordemDeServicoEntitty);
        }    
        return new OrdemDeServicoDTO();
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
        
    }

    @Override
    public OrdemDeServicoDTO buscarVeic(long id) {
       return null; 
    }
    
}
