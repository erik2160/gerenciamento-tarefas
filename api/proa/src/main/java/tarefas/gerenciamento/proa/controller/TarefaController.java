package tarefas.gerenciamento.proa.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tarefas.gerenciamento.proa.domain.model.Tarefa;
import tarefas.gerenciamento.proa.service.TarefaService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(final TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        tarefaService.criarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }

    @GetMapping
    public ResponseEntity<List <Tarefa>> listarTodasTarefas() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> listarTarefa(@PathVariable int id) {
        Optional<Tarefa> tarefa = tarefaService.listarPorId(id);
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable int id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarTarefa(@PathVariable int id) {
        return null;
    }
}
