package adv.coral.service;

import adv.coral.model.Presenca;
import adv.coral.repository.PresencaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PresencaService {

    private final PresencaRepository presencaRepository;

    public List<Presenca> getAll(){
        return presencaRepository.findAll();
    }

    public boolean exists(long id){
        return presencaRepository.existsById(id);
    }

    public Presenca findById(long id){
        return presencaRepository.findById(id).orElse(null);
    }
}
