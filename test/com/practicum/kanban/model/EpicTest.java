package com.practicum.kanban.model;

import com.practicum.kanban.service.TaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {
    TaskManager taskManager = Managers.getDefault();

    @Test
    void testEpicCannotAddItselfAsSubtask() {
        Epic epic = new Epic("Эпик", "Описание", 1);
        taskManager.createEpic(epic);

        Subtask subtask = new Subtask("Подзадача", "Описание", 2, TaskStatus.NEW, 1);
        taskManager.createSubtask(subtask);

        assertTrue(taskManager.getAllSubtasks().contains(subtask));
    }

    @Test
    void testEpicCannotReferenceNonExistingSubtask() {
        Epic epic = new Epic("Эпик", "Описание", 1);
        taskManager.createEpic(epic);

        Subtask subtask = new Subtask("Подзадача", "Описание", 2, TaskStatus.NEW, 99);
        taskManager.createSubtask(subtask);

        assertFalse(taskManager.getAllSubtasks().contains(subtask));
    }
}
