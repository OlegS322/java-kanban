package com.yandexPracticum.kanban;

import com.yandexPracticum.kanban.model.*;
import com.yandexPracticum.kanban.service.*;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Создание двух задач
        Task task1 = new Task("Задача 1", "Описание задачи 1", 0, TaskStatus.NEW);
        Task task2 = new Task("Задача 2", "Описание задачи 2", 0, TaskStatus.NEW);

        taskManager.createTask(task1);
        taskManager.createTask(task2);

        // Создание эпика с двумя подзадачами
        Epic epic1 = new Epic("Эпик 1", "Описание эпика 1", 0);
        taskManager.createEpic(epic1);

        Subtask subtask1 = new Subtask("Подзадача 1", "Описание подзадачи 1", 0, TaskStatus.NEW, epic1.getId());
        Subtask subtask2 = new Subtask("Подзадача 2", "Описание подзадачи 2", 0, TaskStatus.NEW, epic1.getId());

        taskManager.createSubtask(subtask1);
        taskManager.createSubtask(subtask2);

        // Создание эпика с одной подзадачей
        Epic epic2 = new Epic("Эпик 2", "Описание эпика 2", 0);
        taskManager.createEpic(epic2);

        Subtask subtask3 = new Subtask("Подзадача 3", "Описание подзадачи 3", 0, TaskStatus.NEW, epic2.getId());
        taskManager.createSubtask(subtask3);

        // Вывод списков эпиков, задач и подзадач
        System.out.println("Список задач:");
        for (Task task : taskManager.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("\nСписок эпиков:");
        for (Epic epic : taskManager.getAllEpics()) {
            System.out.println(epic);
        }

        System.out.println("\nСписок подзадач:");
        for (Subtask subtask : taskManager.getAllSubtasks()) {
            System.out.println(subtask);
        }

        // Изменение статусов задач и подзадач
        task1.setStatus(TaskStatus.IN_PROGRESS);
        taskManager.updateTask(task1);

        task2.setStatus(TaskStatus.DONE);
        taskManager.updateTask(task2);

        subtask1.setStatus(TaskStatus.DONE);
        taskManager.updateSubtask(subtask1);

        subtask2.setStatus(TaskStatus.IN_PROGRESS);
        taskManager.updateSubtask(subtask2);

        subtask3.setStatus(TaskStatus.DONE);
        taskManager.updateSubtask(subtask3);

        // Вывод обновленных задач, эпиков и подзадач
        System.out.println("\nОбновленные задачи:");
        for (Task task : taskManager.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("\nОбновленные эпики:");
        for (Epic epic : taskManager.getAllEpics()) {
            System.out.println(epic);
        }

        System.out.println("\nОбновленные подзадачи:");
        for (Subtask subtask : taskManager.getAllSubtasks()) {
            System.out.println(subtask);
        }

        // Удаление одной задачи и одного эпика
        taskManager.deleteTaskById(task1.getId());
        taskManager.deleteEpicById(epic1.getId());

        // Вывод списков задач, эпиков и подзадач после удаления
        System.out.println("\nСписок задач после удаления:");
        for (Task task : taskManager.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("\nСписок эпиков после удаления:");
        for (Epic epic : taskManager.getAllEpics()) {
            System.out.println(epic);
        }

        System.out.println("\nСписок подзадач после удаления:");
        for (Subtask subtask : taskManager.getAllSubtasks()) {
            System.out.println(subtask);
        }
    }
}
