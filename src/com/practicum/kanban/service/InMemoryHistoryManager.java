package com.practicum.kanban.service;

import com.practicum.kanban.model.Task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private static final int HISTORY_LIMIT = 10;
    private LinkedList<Task> history = new LinkedList<>();

    @Override
    public void add(Task task) {
        if (history.size() == HISTORY_LIMIT) {
            history.removeFirst();
        }
        history.add(task);
    }

    @Override
    public List<Task> getHistory() {
        return new ArrayList<>(history);
    }
}
