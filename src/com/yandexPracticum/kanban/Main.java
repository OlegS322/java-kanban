package com.yandexPracticum.kanban;

import com.yandexPracticum.kanban.model.*;
import com.yandexPracticum.kanban.service.*;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefault();
        HistoryManager historyManager = Managers.getDefaultHistory();
    }
}
