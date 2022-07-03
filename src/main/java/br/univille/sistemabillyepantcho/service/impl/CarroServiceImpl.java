package br.univille.sistemabillyepantcho.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sistemabillyepantcho.dto.CarroDTO;
import br.univille.sistemabillyepantcho.entity.Carro;
import br.univille.sistemabillyepantcho.mapper.CarroMapper;
import br.univille.sistemabillyepantcho.repository.CarroRepository;
import br.univille.sistemabillyepantcho.service.CarroService;

import java.util.List;
import java.util.Optional;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroRepository repository;
    private CarroMapper mapper = Mappers.getMapper(CarroMapper.class);

    @Override
    public List<CarroDTO> getAll() {
        return mapper.mapCarro(repository.findAll());        
    }

    @Override
    public CarroDTO save(CarroDTO carroDTO) {
        Carro carroEntitty = mapper.mapCarroDTO(carroDTO);
        repository.save(carroEntitty);
        return mapper.mapCarro(carroEntitty);
    }

    @Override
    public CarroDTO buscarPeloId(long id) {
        Optional<Carro> carro = repository.findById(id); 
        if (carro.isPresent()){
            Carro carroEntitty = carro.get();
            return mapper.mapCarro(carroEntitty);
        }    
        return new CarroDTO();
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id); 
        
    }
    
}
