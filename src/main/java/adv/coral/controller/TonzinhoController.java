package adv.coral.controller;

import java.util.List;
import java.util.stream.Collectors;

import adv.coral.dtos.TonzinhoDTO;
import adv.coral.model.Tonzinho;
import adv.coral.service.TonzinhoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/tonzinhos")
@RequiredArgsConstructor
public class TonzinhoController {

    private final TonzinhoService tonzinhoService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<TonzinhoDTO>> getAll() {
        List<TonzinhoDTO> result =
                tonzinhoService.getAll()
                        .stream()
                        .map(this::map)
                        .collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<TonzinhoDTO> findById(@PathVariable long id) {
        if (!tonzinhoService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        TonzinhoDTO dto = this.map(tonzinhoService.findById(id));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    private TonzinhoDTO map(Tonzinho tonzinho) {
        TonzinhoDTO dto = modelMapper.map(tonzinho, TonzinhoDTO.class);
        return dto;
    }
}
