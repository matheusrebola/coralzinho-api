package adv.coral.controller;


import adv.coral.dtos.AlunoDTO;
import adv.coral.model.Aluno;
import adv.coral.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {
    private final AlunoService alunoService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> getAll() {
        List<AlunoDTO> result =
                alunoService.getAll()
                        .stream()
                        .map(this::map)
                        .collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AlunoDTO> findById(@PathVariable long id) {
        if (!alunoService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        AlunoDTO dto = this.map(alunoService.findById(id));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    private AlunoDTO map(Aluno aluno) {
        AlunoDTO dto = modelMapper.map(aluno, AlunoDTO.class);
        return dto;
    }
}
