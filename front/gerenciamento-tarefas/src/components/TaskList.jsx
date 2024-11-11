import React from "react";
import "./TaskList.css";

function TaskList({ tasks, editTask, deleteTask }) {
    return (
        <div>
            <h2>Lista de Tarefas</h2>
            <ul>
                {tasks.map((task) => (
                    <li
                        key={task.id}
                        className={`task-item priority-${task.prioridade}`}
                    >
                        <h3>{task.nome}</h3>
                        <p>{task.descricao}</p>
                        <p>Prioridade: {task.prioridade}</p>
                        <p>Data de Vencimento: {task.validade}</p>
                        <button onClick={() => editTask(task)}>
                            Editar
                        </button>
                        <button onClick={() => deleteTask(task.id)}>
                            Excluir
                        </button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default TaskList;
