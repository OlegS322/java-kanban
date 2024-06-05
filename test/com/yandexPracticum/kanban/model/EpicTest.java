package com.yandexPracticum.kanban.model;

import com.yandexPracticum.kanban.service.TaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {
    TaskManager taskManager = Managers.getDefault();

    @Test
    void testEpicCannotAddItselfAsSubtask() {
        Epic epic = new Epic("Epic", "Description", 1);
        taskManager.createEpic(epic);

        Subtask subtask = new Subtask("Epic", "Description", 1, TaskStatus.NEW, epic.getId());
        taskManager.createSubtask(subtask);

        assertFalse(taskManager.getAllSubtasks().contains(subtask));
    }


}