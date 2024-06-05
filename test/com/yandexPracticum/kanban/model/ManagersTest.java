package com.yandexPracticum.kanban.model;

import com.yandexPracticum.kanban.service.HistoryManager;
import com.yandexPracticum.kanban.service.TaskManager;
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
