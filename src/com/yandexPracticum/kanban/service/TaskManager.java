package com.yandexPracticum.kanban.service;

import com.yandexPracticum.kanban.model.Epic;
import com.yandexPracticum.kanban.model.Subtask;
import com.yandexPracticum.kanban.model.Task;

import java.util.List;

public interface TaskManager {
    // метод для просмотра 10 последних задач
    List<Task> getHistory();
    // Методы для работы с обычными задачами
    List<Task> getAllTasks();

    void deleteAllTasks();

    Task getTaskById(int id);

    void createTask(Task task);

    void updateTask(Task task);

    void deleteTaskById(int id);

    // Методы для работы с подзадачами
    List<Subtask> getAllSubtasks();

    void deleteAllSubtasks();

    Subtask getSubtaskById(int id);

    void createSubtask(Subtask subtask);

    void updateSubtask(Subtask subtask);

    void deleteSubtaskById(int id);

    // Методы для работы с эпиками
    List<Epic> getAllEpics();

    void deleteAllEpics();

    Epic getEpicById(int id);

    void createEpic(Epic epic);

    void updateEpic(Epic epic);

    void deleteEpicById(int id);

    // Метод для получения всех подзадач определённого эпика
    List<Subtask> getSubtasksForEpic(int epicId);
}
