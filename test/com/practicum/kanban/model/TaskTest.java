package com.practicum.kanban.model;

import com.practicum.kanban.service.TaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testTaskEqualityById() {
        Task task1 = new Task("Задача 1", "Описание 1", 1, TaskStatus.NEW);
        Task task2 = new Task("Задача 2", "Описание 2", 1, TaskStatus.NEW);

        assertEquals(task1, task2);
    }

    @Test
    public void testTaskUnchanged() {
        TaskManager taskManager = Managers.getDefault();

        Task originalTask = new Task("Оригинальное задание", "Оригинальное описание", 1, TaskStatus.NEW);
        taskManager.createTask(originalTask);

        Task modifiedTask = new Task("Изменное задание", "Измененное описание", 1, TaskStatus.IN_PROGRESS);
        taskManager.updateTask(modifiedTask);

        Task retrievedTask = taskManager.getTaskById(1);

        assertEquals(originalTask, retrievedTask);
    }
}


