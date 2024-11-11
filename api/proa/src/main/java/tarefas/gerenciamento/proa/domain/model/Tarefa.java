package tarefas.gerenciamento.proa.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30, nullable = false)
    private String nome;

    @Column(length = 150, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private int prioridade;

    @Column(nullable = false)
    private Date validade;
}