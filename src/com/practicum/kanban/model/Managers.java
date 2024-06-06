package com.practicum.kanban.model;

import com.practicum.kanban.service.HistoryManager;
import com.practicum.kanban.service.InMemoryHistoryManager;
import com.practicum.kanban.service.InMemoryTaskManager;
import com.practicum.kanban.service.TaskManager;

public class Managers {
    public static TaskManager getDefault() {
        return new InMemoryTaskManager();
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }
}
