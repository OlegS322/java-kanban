package com.yandexPracticum.kanban.service;

import com.yandexPracticum.kanban.model.Task;
import com.yandexPracticum.kanban.model.TaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {

    private InMemoryHistoryManager historyManager;

    @BeforeEach
    void setUp() {
        historyManager = new InMemoryHistoryManager();
    }

    @Test
    void add() {
        Task task1 = new Task("Задача 1", "Описание 1", 1, TaskStatus.NEW);
        Task task2 = new Task("Задача 2", "Описание 2", 2, TaskStatus.NEW);

        historyManager.add(task1);
        historyManager.add(task2);

        List<Task> history = historyManager.getHistory();
        assertEquals(2, history.size(), "История должна содержать 2 задачи");
        assertEquals(task1, history.get(0), "Первая задача в истории должна быть задача 1");
        assertEquals(task2, history.get(1), "Вторая задача в истории должна быть задача 2");
    }

    @Test
    void getHistory() {
        Task task1 = new Task("Задача 1", "Описание 1", 1, TaskStatus.NEW);
        Task task2 = new Task("Задача 2", "Описание 2", 2, TaskStatus.NEW);
        Task task3 = new Task("Задача 3", "Описание 3", 3, TaskStatus.NEW);

        historyManager.add(task1);
        historyManager.add(task2);
        historyManager.add(task3);

        List<Task> history = historyManager.getHistory();
        assertEquals(3, history.size(), "История должна содержать 3 задачи");
        assertEquals(task1, history.get(0), "Первая задача в истории должна быть задача 1");
        assertEquals(task2, history.get(1), "Вторая задача в истории должна быть задача 2");
        assertEquals(task3, history.get(2), "Третья задача в истории должна быть задача 3");
    }

    @Test
    void historyLimit() {
        for (int i = 1; i <= 12; i++) {
            historyManager.add(new Task("Задача " + i, "Описание " + i, i, TaskStatus.NEW));
        }

        List<Task> history = historyManager.getHistory();
        assertEquals(10, history.size(), "История должна содержать только 10 задач");
        assertEquals("Задача 3", history.get(0).getTitle(), "Первая задача в истории должна быть 'Задача 3'");
        assertEquals("Задача 12", history.get(9).getTitle(), "Последняя задача в истории должна быть 'Задача 12'");
    }
}

