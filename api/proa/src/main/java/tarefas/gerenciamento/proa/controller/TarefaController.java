package tarefas.gerenciamento.proa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tarefas.gerenciamento.proa.domain.model.Tarefa;
import tarefas.gerenciamento.proa.service.TarefaService;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<Tarefa>> listarTodasTarefas() {
        List<Tarefa> tarefa = tarefaService.listarTarefas();
        return ResponseEntity.status(HttpStatus.OK).body(tarefa);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Tarefa> listarTarefa(@PathVariable int id) {
        Optional<Tarefa> tarefa = tarefaService.listarPorId(id);

        return tarefa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable int id, @RequestBody Tarefa tarefaAtualizada) {
        Optional<Tarefa> tarefa = tarefaService.atualizarTarefa(id, tarefaAtualizada);

        return tarefa.map(ResponseEntity::ok)
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
