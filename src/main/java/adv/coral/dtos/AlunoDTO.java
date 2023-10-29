package adv.coral.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AlunoDTO {
    private Long id;
    private String nome;
    private Instant dataCadastro;
    private boolean ativo;
}
