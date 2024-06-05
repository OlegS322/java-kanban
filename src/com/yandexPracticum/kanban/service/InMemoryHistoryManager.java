//package com.yandexPracticum.kanban.service;
//
//import com.yandexPracticum.kanban.model.Task;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//public class InMemoryHistoryManager implements HistoryManager {
//    private static final int HISTORY_LIMIT = 10;
//    private LinkedList<Task> history = new LinkedList<>();
//
//    @Override
//    public void add(Task task) {
//        // Remove any existing task with the same ID
//        history.removeIf(existingTask -> existingTask.getId() == task.getId());
//
//        if (history.size() == HISTORY_LIMIT) {
//            history.removeFirst();
//        }
//        history.add(task);
//    }
//
//    @Override
//    public List<Task> getHistory() {
//        return new ArrayList<>(history);
//    }
//}
//
package com.yandexPracticum.kanban.service;

import com.yandexPracticum.kanban.model.Task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private static final int HISTORY_LIMIT = 10;
    private LinkedList<Task> history = new LinkedList<>();

    @Override
    public void add(Task task) {
        Task taskCopy = new Task(task.getTitle(), task.getDescription(), task.getId(), task.getStatus());
        if (history.size() == HISTORY_LIMIT) {
            history.removeFirst();
        }
        history.add(taskCopy);
    }

    @Override
    public List<Task> getHistory() {
        return new ArrayList<>(history);
    }
}
