import React, { useState } from 'react';
import TaskForm from './components/TaskForm';
import TaskList from './components/TaskList';
import './App.css';

function App() {
  const [tasks, setTasks] = useState([]);
  const [currentTask, setCurrentTask] = useState(null);

  const addTask = (task) => {
    setTasks([...tasks, { ...task, id: Date.now() }]);
  };

  const updateTask = (updateTask) => {
    setTasks(tasks.map((task) => (task.id === updateTask.id ? updateTask : task)));
    setCurrentTask(null);
  };

  const deleteTask = (taskId) => {
    setTasks(tasks.filter((task) => task.id !== taskId));
  };

  const editTask = (task) => {
    setCurrentTask(task);
  };

  return (
    <div className="App">
      <h1>Gerenciamento de Tarefas</h1>
      <div className="task-container">
        <TaskList tasks={tasks} editTask={editTask} deleteTask={deleteTask} />
        <TaskForm addTask={addTask} updateTask={updateTask} currentTask={currentTask} />
      </div>
    </div>
  );
}

export default App;