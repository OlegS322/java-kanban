package com.yandexPracticum.kanban.service;

import com.yandexPracticum.kanban.model.Task;

import java.util.List;

public interface HistoryManager {
    void add(Task task);

    List<Task> getHistory();
}
