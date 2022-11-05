package br.univille.sistemabillyepantcho.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sistemabillyepantcho.dto.VeiculoDTO;
import br.univille.sistemabillyepantcho.entity.Veiculo;
import br.univille.sistemabillyepantcho.mapper.VeiculoMapper;
import br.univille.sistemabillyepantcho.repository.VeiculoRepository;
import br.univille.sistemabillyepantcho.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService {
    
    @Autowired
    private VeiculoRepository repository;
    private VeiculoMapper mapper = Mappers.getMapper(VeiculoMapper.class);

    @Override
    public List<VeiculoDTO> getAll() {
        return mapper.mapVeiculo(repository.findAll());
    }

    @Override
    public VeiculoDTO save(VeiculoDTO veiculo) {
        Veiculo veiculoEntitty = mapper.mapVeiculoDTO(veiculo);
        repository.save(veiculoEntitty);
        return mapper.mapVeiculo(veiculoEntitty);
    }

    @Override
    public VeiculoDTO buscarPeloId(long id) {
        Optional<Veiculo> veiculo = repository.findById(id);   
        if (veiculo.isPresent()){
            Veiculo veiculoEntitty = veiculo.get();
            return mapper.mapVeiculo(veiculoEntitty);
        }    
        return new VeiculoDTO();
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);  
    }

    @Override
    public List<VeiculoDTO> buscarVeic(long id) {
        return mapper.mapVeiculo(repository.findByCliente_Id(id));
    } 
}
