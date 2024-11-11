package tarefas.gerenciamento.proa.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tarefas.gerenciamento.proa.domain.model.Tarefa;
import tarefas.gerenciamento.proa.domain.repository.TarefaRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public void criarTarefa(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> listarPorId(int id) {
        return tarefaRepository.findById(id);
    }

    public void atualizarTarefa(int id) {
        return;
    }

    public void deletarTarefa(int id) { tarefaRepository.deleteById(id);}
}
