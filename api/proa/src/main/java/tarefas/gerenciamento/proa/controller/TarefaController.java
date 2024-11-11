package tarefas.gerenciamento.proa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tarefas.gerenciamento.proa.domain.model.Tarefa;
import tarefas.gerenciamento.proa.dto.TarefaDTO;
import tarefas.gerenciamento.proa.service.TarefaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(final TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        tarefaService.criarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<TarefaDTO>> listarTodasTarefas() {
        List<Tarefa> tarefas = tarefaService.listarTarefas();
        List<TarefaDTO> tarefaDTOs = tarefas.stream()
                .map(tarefa -> new TarefaDTO(
                        tarefa.getId(),
                        tarefa.getNome(),
                        tarefa.getDescricao(),
                        tarefa.getPrioridade(),
                        tarefa.getValidade()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(tarefaDTOs);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<TarefaDTO> listarTarefa(@PathVariable int id) {
        Optional<Tarefa> tarefa = tarefaService.listarPorId(id);

        return tarefa.map(t -> new TarefaDTO(
                        t.getId(),
                        t.getNome(),
                        t.getDescricao(),
                        t.getPrioridade(),
                        t.getValidade()))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<TarefaDTO> atualizarTarefa(@PathVariable int id, @RequestBody Tarefa tarefaAtualizada) {
        Optional<Tarefa> tarefa = tarefaService.atualizarTarefa(id, tarefaAtualizada);

        return tarefa.map(t -> new TarefaDTO(
                        t.getId(),
                        t.getNome(),
                        t.getDescricao(),
                        t.getPrioridade(),
                        t.getValidade()))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<String> deletarTarefa(@PathVariable int id) {
        int tarefaExiste = tarefaService.deletarTarefa(id);
        if (tarefaExiste == 1) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletado!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado!");
    }
}
