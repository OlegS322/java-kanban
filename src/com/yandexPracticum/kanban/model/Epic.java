package com.yandexPracticum.kanban.model;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<Integer> subtaskIds;

    public Epic(String title, String description, int id) {
        super(title, description, id, TaskStatus.NEW);
        this.subtaskIds = new ArrayList<>();
    }

    public List<Integer> getSubtaskIds() {
        return subtaskIds;
    }

    public void addSubtaskId(int subtaskId) {
        this.subtaskIds.add(subtaskId);
    }

    public void removeSubtaskId(int subtaskId) {
        this.subtaskIds.remove(Integer.valueOf(subtaskId));
    }

    @Override
    public String toString() {
        return "com.yandexPracticum.kanban.model.Epic{" +
                "subtaskIds=" + subtaskIds +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
