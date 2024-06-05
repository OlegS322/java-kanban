//package com.yandexPracticum.kanban.service;
//
//import com.yandexPracticum.kanban.model.Managers;
//import com.yandexPracticum.kanban.model.Task;
//import com.yandexPracticum.kanban.model.TaskStatus;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class InMemoryHistoryManagerTest {
//
//    private HistoryManager historyManager = Managers.getDefaultHistory();
//
//    @BeforeEach
//    void setUp() {
//        historyManager = new InMemoryHistoryManager();
//    }
//
//    @Test
//    void add() {
//        Task task1 = new Task("Задача 1", "Описание 1", 1, TaskStatus.NEW);
//        Task task2 = new Task("Задача 2", "Описание 2", 2, TaskStatus.NEW);
//
//        historyManager.add(task1);
//        historyManager.add(task2);
//
//        List<Task> history = historyManager.getHistory();
//        assertEquals(2, history.size(), "История должна содержать 2 задачи");
//        assertEquals(task1, history.get(0), "Первая задача в истории должна быть задача 1");
//        assertEquals(task2, history.get(1), "Вторая задача в истории должна быть задача 2");
//    }
//
//    @Test
//    void getHistory() {
//        Task task1 = new Task("Задача 1", "Описание 1", 1, TaskStatus.NEW);
//        Task task2 = new Task("Задача 2", "Описание 2", 2, TaskStatus.NEW);
//        Task task3 = new Task("Задача 3", "Описание 3", 3, TaskStatus.NEW);
//
//        historyManager.add(task1);
//        historyManager.add(task2);
//        historyManager.add(task3);
//
//        List<Task> history = historyManager.getHistory();
//        assertEquals(3, history.size(), "История должна содержать 3 задачи");
//        assertEquals(task1, history.get(0), "Первая задача в истории должна быть задача 1");
//        assertEquals(task2, history.get(1), "Вторая задача в истории должна быть задача 2");
//        assertEquals(task3, history.get(2), "Третья задача в истории должна быть задача 3");
//    }
//
//    @Test
//    void historyLimit() {
//        for (int i = 1; i <= 12; i++) {
//            historyManager.add(new Task("Задача " + i, "Описание " + i, i, TaskStatus.NEW));
//        }
//
//        List<Task> history = historyManager.getHistory();
//        assertEquals(10, history.size(), "История должна содержать только 10 задач");
//        assertEquals("Задача 3", history.get(0).getTitle(), "Первая задача в истории должна быть 'Задача 3'");
//        assertEquals("Задача 12", history.get(9).getTitle(), "Последняя задача в истории должна быть 'Задача 12'");
//    }
//
//    @Test
//    void testTaskChangeInHistory() {
//        Task task1 = new Task("Задача", "Описание", 1, TaskStatus.NEW);
//
//        historyManager.add(task1);
//        assertEquals(1, historyManager.getHistory().size(), "История должна содержать 1 задачу после первого добавления");
//
//        Task task2 = new Task("Измененная задача", "Измененное описание", 1, TaskStatus.IN_PROGRESS);
//
//        historyManager.add(task2);
//
//        List<Task> history = historyManager.getHistory();
//        assertEquals(1, history.size(), "История должна содержать 1 версию задачи");
//
//        Task updatedTask = history.get(0);
//        assertEquals("Измененная задача", updatedTask.getTitle(), "Название задачи должно быть 'Измененная задача'");
//        assertEquals("Измененное описание", updatedTask.getDescription(), "Описание задачи должно быть 'Измененное описание'");
//        assertEquals(TaskStatus.IN_PROGRESS, updatedTask.getStatus(), "Статус задачи должен быть IN_PROGRESS");
//    }
//}
//
package com.yandexPracticum.kanban.service;

import com.yandexPracticum.kanban.model.Task;
import com.yandexPracticum.kanban.model.TaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {
    private HistoryManager historyManager;

    @BeforeEach
    void setUp() {
        historyManager = new InMemoryHistoryManager();
    }

    @Test
    void testTaskChangeInHistory() {
        Task task = new Task("Изначальная задача", "Изначальное описание", 1, TaskStatus.NEW);
        historyManager.add(task);

        // Change task details
        Task updatedTask = new Task("Обновленная задача", "Обновленное описание", 1, TaskStatus.IN_PROGRESS);
        historyManager.add(updatedTask);

        List<Task> history = historyManager.getHistory();
        assertEquals(2, history.size(), "История должна содержать 2 задачи после обновления");

        Task firstTaskFromHistory = history.get(0);
        assertEquals("Изначальная задача", firstTaskFromHistory.getTitle(), "Название первой задачи должно быть изначальным");
        assertEquals("Изначальное описание", firstTaskFromHistory.getDescription(), "Описание первой задачи должно быть изначальным");
        assertEquals(TaskStatus.NEW, firstTaskFromHistory.getStatus(), "Статус первой задачи должен быть изначальным");

        Task secondTaskFromHistory = history.get(1);
        assertEquals("Обновленная задача", secondTaskFromHistory.getTitle(), "Название второй задачи должно быть обновленным");
        assertEquals("Обновленное описание", secondTaskFromHistory.getDescription(), "Описание второй задачи должно быть обновленным");
        assertEquals(TaskStatus.IN_PROGRESS, secondTaskFromHistory.getStatus(), "Статус второй задачи должен быть обновленным");
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
