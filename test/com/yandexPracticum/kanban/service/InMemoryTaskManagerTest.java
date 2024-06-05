package com.yandexPracticum.kanban.service;

import com.yandexPracticum.kanban.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {
    @Test
    void testTaskManagerOperations() {
        // Создаем экземпляр InMemoryTaskManager
        TaskManager taskManager = new InMemoryTaskManager();

        // Создаем новый Epic
        Epic epic = new Epic("Эпик", "Описание", 1);

        // Создаем новый Subtask, привязанный к Epic
        Subtask subtask = new Subtask("Подзадача", "Описание", 2, TaskStatus.NEW, 1);

        // Добавляем Epic в менеджер задач
        taskManager.createEpic(epic);

        // Добавляем Subtask в менеджер задач
        taskManager.createSubtask(subtask);

        // Получаем Subtask из менеджера задач
        Subtask retrievedSubtask = (Subtask) taskManager.getSubtaskById(2);

        // Проверяем, что Subtask успешно создан и добавлен в менеджер задач
        assertNotNull(retrievedSubtask);
        assertEquals(subtask, retrievedSubtask);
    }

    @Test
    public void testTaskIdConflict() {
        TaskManager taskManager = Managers.getDefault();

        Task task1 = new Task("Задача 1", "Описание 1", 1, TaskStatus.NEW);
        Task task2 = new Task("Задача 2", "Описание 2", 2, TaskStatus.NEW);
        taskManager.createTask(task1);
        taskManager.createTask(task2);

        assertNotEquals(task1.getId(), task2.getId());
    }
}
