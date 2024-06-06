package com.practicum.kanban.model;

import com.practicum.kanban.service.TaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {
    TaskManager taskManager = Managers.getDefault();

    @Test
    void testSubtaskCannotReferenceItsEpic() {
        Epic epic = new Epic("Эпик", "Описание", 1);
        taskManager.createEpic(epic);

        Subtask subtask = new Subtask("Подзадача", "Описание", 2, TaskStatus.NEW, 1);
        taskManager.createSubtask(subtask);

        assertTrue(taskManager.getAllSubtasks().contains(subtask));
    }

    @Test
    void testSubtaskCannotReferenceNonExistingEpic() {
        Subtask subtask = new Subtask("Подзадача", "Описание", 2, TaskStatus.NEW, 99);
        taskManager.createSubtask(subtask);

        assertFalse(taskManager.getAllSubtasks().contains(subtask));
    }
}
