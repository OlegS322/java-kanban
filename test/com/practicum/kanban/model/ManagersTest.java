package com.practicum.kanban.model;

import com.practicum.kanban.service.HistoryManager;
import com.practicum.kanban.service.TaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagersTest {

    @Test
    void getDefaultTaskManager() {
        TaskManager taskManager = Managers.getDefault();

        assertNotNull(taskManager, "Экземпляр TaskManager должен быть проинициализирован");
    }

    @Test
    void getDefaultHistoryManager() {
        HistoryManager historyManager = Managers.getDefaultHistory();

        assertNotNull(historyManager, "Экземпляр HistoryManager должен быть проинициализирован");
    }
}
