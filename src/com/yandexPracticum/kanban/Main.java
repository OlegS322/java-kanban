package com.yandexPracticum.kanban;

import com.yandexPracticum.kanban.model.*;
import com.yandexPracticum.kanban.service.*;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefault();

        Task task1 = new Task("Task 1", "Description 1", 0, TaskStatus.NEW);
        Task task2 = new Task("Task 2", "Description 2", 0, TaskStatus.NEW);
        Epic epic1 = new Epic("Epic 1", "Description Epic 1", 0);

        taskManager.createEpic(epic1);

        Subtask subtask1 = new Subtask("Subtask 1", "Description Subtask 1", 0, TaskStatus.NEW, epic1.getId());
        Subtask subtask2 = new Subtask("Subtask 2", "Description Subtask 2", 0, TaskStatus.NEW, epic1.getId());

        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createSubtask(subtask1);
        taskManager.createSubtask(subtask2);

        taskManager.getTaskById(task1.getId());
        taskManager.getSubtaskById(subtask1.getId());
        taskManager.getEpicById(epic1.getId());

        printAllTasks(taskManager);
    }

    private static void printAllTasks(TaskManager manager) {
        System.out.println("Задачи:");
        for (Task task : manager.getAllTasks()) {
            System.out.println(task);
        }
        System.out.println("Эпики:");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println(epic);

            for (Subtask subtask : manager.getSubtasksForEpic(epic.getId())) {
                System.out.println("--> " + subtask);
            }
        }
        System.out.println("Подзадачи:");
        for (Subtask subtask : manager.getAllSubtasks()) {
            System.out.println(subtask);
        }

        System.out.println("История:");
        for (Task task : manager.getHistory()) {
            System.out.println(task);
        }
    }
}
