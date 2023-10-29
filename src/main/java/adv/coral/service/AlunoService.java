package adv.coral.service;

import adv.coral.model.Aluno;
import adv.coral.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    public boolean exists(long id) {
        return alunoRepository.existsById(id);
    }

    public Aluno findById(long id) {
        return alunoRepository.findById(id).orElse(null);
    }
}
