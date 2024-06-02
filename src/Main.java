public class Main {
    public static void main(String[] args) {
        // Создание менеджера задач
        TaskManager taskManager = new TaskManager();

        // Создание трех обычных задач
        Task task1 = new Task("Задача A", "Описание задачи A", 0, TaskStatus.NEW);
        Task task2 = new Task("Задача B", "Описание задачи B", 0, TaskStatus.NEW);
        Task task3 = new Task("Задача C", "Описание задачи C", 0, TaskStatus.NEW);

        // Добавление задач в менеджер
        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createTask(task3);

        // Создание первого эпика с тремя подзадачами
        Epic epic1 = new Epic("Эпик X", "Описание эпика X", 0);
        taskManager.createEpic(epic1);

        Subtask subtask1 = new Subtask("Подзадача X1", "Описание подзадачи X1", 0, TaskStatus.NEW, epic1.getId());
        Subtask subtask2 = new Subtask("Подзадача X2", "Описание подзадачи X2", 0, TaskStatus.NEW, epic1.getId());
        Subtask subtask3 = new Subtask("Подзадача X3", "Описание подзадачи X3", 0, TaskStatus.NEW, epic1.getId());

        // Добавление подзадач в менеджер
        taskManager.createSubtask(subtask1);
        taskManager.createSubtask(subtask2);
        taskManager.createSubtask(subtask3);

        // Создание второго эпика с двумя подзадачами
        Epic epic2 = new Epic("Эпик Y", "Описание эпика Y", 0);
        taskManager.createEpic(epic2);

        Subtask subtask4 = new Subtask("Подзадача Y1", "Описание подзадачи Y1", 0, TaskStatus.NEW, epic2.getId());
        Subtask subtask5 = new Subtask("Подзадача Y2", "Описание подзадачи Y2", 0, TaskStatus.NEW, epic2.getId());

        // Добавление подзадач в менеджер
        taskManager.createSubtask(subtask4);
        taskManager.createSubtask(subtask5);

        // Вывод начальных списков задач, эпиков и подзадач
        System.out.println("Начальные списки задач:");
        System.out.println("Задачи:");
        for (Task task : taskManager.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("\nЭпики:");
        for (Epic epic : taskManager.getAllEpics()) {
            System.out.println(epic);
        }

        System.out.println("\nПодзадачи:");
        for (Subtask subtask : taskManager.getAllSubtasks()) {
            System.out.println(subtask);
        }

        // Изменение статусов задач и подзадач
        task1.setStatus(TaskStatus.IN_PROGRESS);
        taskManager.updateTask(task1);

        task2.setStatus(TaskStatus.DONE);
        taskManager.updateTask(task2);

        subtask1.setStatus(TaskStatus.IN_PROGRESS);
        taskManager.updateSubtask(subtask1);

        subtask2.setStatus(TaskStatus.DONE);
        taskManager.updateSubtask(subtask2);

        subtask3.setStatus(TaskStatus.DONE);
        taskManager.updateSubtask(subtask3);

        subtask4.setStatus(TaskStatus.DONE);
        taskManager.updateSubtask(subtask4);

        subtask5.setStatus(TaskStatus.DONE);
        taskManager.updateSubtask(subtask5);

        // Вывод обновленных списков задач, эпиков и подзадач
        System.out.println("\nОбновленные списки задач:");
        System.out.println("Задачи:");
        for (Task task : taskManager.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("\nЭпики:");
        for (Epic epic : taskManager.getAllEpics()) {
            System.out.println(epic);
        }

        System.out.println("\nПодзадачи:");
        for (Subtask subtask : taskManager.getAllSubtasks()) {
            System.out.println(subtask);
        }
    }
}
