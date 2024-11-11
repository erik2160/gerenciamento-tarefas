import React from "react";
import './TaskList.css'; 

function TaskList({ tasks, editTask, deleteTask }) {
  return (
    <div>
      <h2>Lista de Tarefas</h2>
      <ul>
        {tasks.map((task) => (
          <li key={task.id} className={`task-item priority-${task.priority}`}>
            <h3>{task.name}</h3>
            <p>{task.description}</p>
            <p>Prioridade: {task.priority}</p>
            <p>Data de Vencimento: {task.dueDate}</p>
            <button onClick={() => editTask(task)}>Editar</button>
            <button onClick={() => deleteTask(task.id)}>Excluir</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TaskList;