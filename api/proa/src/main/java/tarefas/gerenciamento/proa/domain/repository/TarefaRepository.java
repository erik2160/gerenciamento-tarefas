package tarefas.gerenciamento.proa.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tarefas.gerenciamento.proa.domain.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
    void updateTarefaById(int id);
}
