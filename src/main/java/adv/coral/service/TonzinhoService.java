package adv.coral.service;

import adv.coral.model.Tonzinho;
import adv.coral.repository.TonzinhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TonzinhoService {

    private final TonzinhoRepository tonzinhoRepository;

    public List<Tonzinho> getAll() {
        return tonzinhoRepository.findAll();
    }

    public boolean exists(long id) {
        return tonzinhoRepository.existsById(id);
    }

    public Tonzinho findById(long id) {
        return tonzinhoRepository.findById(id).orElse(null);
    }
}
