package tarefas.gerenciamento.proa.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO {
    private int id;
    private String nome;
    private String descricao;
    private int prioridade;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date validade;
}
