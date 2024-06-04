package com.yandexPracticum.kanban.model;

import com.yandexPracticum.kanban.service.InMemoryTaskManager;
import com.yandexPracticum.kanban.service.TaskManager;

public class Managers {
    public static TaskManager getDefault() {
        return new InMemoryTaskManager();
    }
}
