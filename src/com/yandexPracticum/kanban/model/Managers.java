package com.yandexPracticum.kanban.model;

import com.yandexPracticum.kanban.service.HistoryManager;
import com.yandexPracticum.kanban.service.InMemoryHistoryManager;
import com.yandexPracticum.kanban.service.InMemoryTaskManager;
import com.yandexPracticum.kanban.service.TaskManager;

public class Managers {
    public static TaskManager getDefault() {
        return new InMemoryTaskManager();
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }
}
