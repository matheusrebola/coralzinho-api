package adv.coral.controller;

import java.util.List;
import java.util.stream.Collectors;

import adv.coral.dtos.PresencaDTO;
import adv.coral.model.Presenca;
import adv.coral.service.PresencaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/presencas")
@RequiredArgsConstructor
public class PresencaController {

    private final PresencaService presencaService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PresencaDTO>> getAll() {
        List<PresencaDTO> result =
                presencaService.getAll()
                        .stream()
                        .map(this::map)
                        .collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<PresencaDTO> findById(@PathVariable long id) {
        if (!presencaService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        PresencaDTO dto = this.map(presencaService.findById(id));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    private PresencaDTO map(Presenca presenca) {
        PresencaDTO dto = modelMapper.map(presenca, PresencaDTO.class);
        return dto;
    }
}
