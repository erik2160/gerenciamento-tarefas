import React, { useState, useEffect } from 'react';

function TaskForm({ addTask, updateTask, curentTask }) {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [priority, setPriority] = useState(1);
  const [dueDate, setDueDate] = useState('');

  useEffect(() => {
    if (curentTask) {
      setName(curentTask.name);
      setDescription(curentTask.description);
      setPriority(curentTask.priority);
      setDueDate(curentTask.dueDate);
    } else {
      setName('');
      setDescription('');
      setPriority(1);
      setDueDate('');
    }
  }, [curentTask]);

  const handleSubmit = (e) => {
    e.preventDefault();
    const task = { name, description, priority, dueDate };
    if (curentTask) {
      updateTask({ ...task, id: curentTask.id });
    } else {
      addTask(task);
    }
    setName('');
    setDescription('');
    setPriority(1);
    setDueDate('');
  };

  return (
    <form onSubmit={handleSubmit} className="TaskForm">
      <input
        type="text"
        placeholder="Nome da Tarefa"
        value={name}
        onChange={(e) => setName(e.target.value)}
        maxLength={30}
        required
      />
      <small>{name.length}/30</small> 

      <textarea
        placeholder="Descrição"
        value={description}
        onChange={(e) => setDescription(e.target.value)}
        maxLength={50}
        required
      />
      <small>{description.length}/50</small> 

      <select value={priority} onChange={(e) => setPriority(e.target.value)}>
        <option value={1}>Prioridade 1</option>
        <option value={2}>Prioridade 2</option>
        <option value={3}>Prioridade 3</option>
      </select>
      
      <input
        type="date"
        value={dueDate}
        onChange={(e) => setDueDate(e.target.value)}
        required
      />
      
      <button type="submit">{curentTask ? 'Atualizar Tarefa' : 'Adicionar Tarefa'}</button>
    </form>
  );
}

export default TaskForm;