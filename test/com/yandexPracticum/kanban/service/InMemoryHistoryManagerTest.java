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
        Task task1 = new Task("Task 1", "Description 1", 1, TaskStatus.NEW);
        Task task2 = new Task("Task 2", "Description 2", 2, TaskStatus.NEW);

        historyManager.add(task1);
        historyManager.add(task2);

        List<Task> history = historyManager.getHistory();
        assertEquals(2, history.size(), "History should contain 2 tasks");
        assertEquals(task1, history.get(0), "First task in history should be task1");
        assertEquals(task2, history.get(1), "Second task in history should be task2");
    }

    @Test
    void getHistory() {
        Task task1 = new Task("Task 1", "Description 1", 1, TaskStatus.NEW);
        Task task2 = new Task("Task 2", "Description 2", 2, TaskStatus.NEW);
        Task task3 = new Task("Task 3", "Description 3", 3, TaskStatus.NEW);

        historyManager.add(task1);
        historyManager.add(task2);
        historyManager.add(task3);

        List<Task> history = historyManager.getHistory();
        assertEquals(3, history.size(), "History should contain 3 tasks");
        assertEquals(task1, history.get(0), "First task in history should be task1");
        assertEquals(task2, history.get(1), "Second task in history should be task2");
        assertEquals(task3, history.get(2), "Third task in history should be task3");
    }

    @Test
    void historyLimit() {
        for (int i = 1; i <= 12; i++) {
            historyManager.add(new Task("Task " + i, "Description " + i, i, TaskStatus.NEW));
        }

        List<Task> history = historyManager.getHistory();
        assertEquals(10, history.size(), "History should contain only 10 tasks");
        assertEquals("Task 3", history.get(0).getTitle(), "First task in history should be 'Task 3'");
        assertEquals("Task 12", history.get(9).getTitle(), "Last task in history should be 'Task 12'");
    }
}
