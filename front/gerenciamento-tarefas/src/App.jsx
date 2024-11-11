import React, { useState, useEffect } from "react";
import TaskForm from "./components/TaskForm";
import TaskList from "./components/TaskList";
import "./App.css";

function App() {
    const [tasks, setTasks] = useState([]);
    const [currentTask, setCurrentTask] = useState(null);

    useEffect(() => {
        fetchTasks();
    }, []);

    const fetchTasks = async () => {
        try {
            const response = await fetch("http://localhost:8080/tarefas");
            const data = await response.json();
            setTasks(data); 
        } catch (error) {
            console.error("Error fetching tasks:", error);
        }
    };

    const addTask = async (task) => {
        try {
            await fetch("http://localhost:8080/tarefas", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    nome: task.name,
                    descricao: task.description,
                    prioridade: task.priority,
                    validade: task.dueDate,
                }),
            });
            fetchTasks(); 
        } catch (error) {
            console.error("Error adding task:", error);
        }
    };

    const updateTask = async (task) => {
        try {
            await fetch(`http://localhost:8080/tarefas/${task.id}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    nome: task.name,
                    descricao: task.description,
                    prioridade: task.priority,
                    validade: task.dueDate,
                }),
            });
            fetchTasks();
            setCurrentTask(null); 
        } catch (error) {
            console.error("Error updating task:", error);
        }
    };

    const deleteTask = async (taskId) => {
        try {
            await fetch(`http://localhost:8080/tarefas/${taskId}`, {
                method: "DELETE",
            });
            fetchTasks();
        } catch (error) {
            console.error("Error deleting task:", error);
        }
    };

    const editTask = (task) => {
        console.log(task);
        setCurrentTask(task);
    };

    return (
        <div className="App">
            <h1>Gerenciamento de Tarefas</h1>
            <div className="task-container">
                <TaskList
                    tasks={tasks}
                    editTask={editTask}
                    deleteTask={deleteTask}
                />
                <TaskForm
                    addTask={addTask}
                    updateTask={updateTask}
                    currentTask={currentTask}
                />
            </div>
        </div>
    );
}

export default App;
