package com.yandexPracticum.kanban.model;

import com.yandexPracticum.kanban.service.TaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {
    TaskManager taskManager = Managers.getDefault();
    @Test
    void testSubtaskCannotReferenceItsEpic() {
        Epic epic = new Epic("Epic", "Description", 1);
        taskManager.createEpic(epic);

        Subtask subtask = new Subtask("Subtask", "Description", 1, TaskStatus.NEW, 1); // Using different ID for the epic
        taskManager.createSubtask(subtask);

        assertFalse(taskManager.getAllSubtasks().contains(subtask));
    }

    @Test
    void testSubtaskCannotReferenceAnotherEpic() {
        Epic epic1 = new Epic("Epic 1", "Description", 1);
        taskManager.createEpic(epic1);

        Epic epic2 = new Epic("Epic 2", "Description", 2);
        taskManager.createEpic(epic2);

        // Trying to reference a different epic
        Subtask subtask = new Subtask("Subtask", "Description", 1, TaskStatus.NEW, epic1.getId());
        taskManager.createSubtask(subtask);

        // Assert that the subtask was not added
        assertFalse(taskManager.getAllSubtasks().contains(subtask));
    }
}