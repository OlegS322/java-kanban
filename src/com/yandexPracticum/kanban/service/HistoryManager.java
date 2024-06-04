package com.yandexPracticum.kanban.service;

import com.yandexPracticum.kanban.model.Task;

public interface HistoryManager  {

    void add(Task task); //помечает задачи как просмотренные

    void getHistory(); // возвращает список
}
