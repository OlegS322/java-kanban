import java.util.ArrayList;
import java.util.List;

// Класс для эпиков
public class Epic extends Task {
    private List<Integer> subtaskIds; // Список идентификаторов подзадач

    // Конструктор класса Epic
    public Epic(String title, String description, int id) {
        super(title, description, id, TaskStatus.NEW);
        this.subtaskIds = new ArrayList<>();
    }

    // Геттеры и методы для работы с подзадачами
    public List<Integer> getSubtaskIds() {
        return subtaskIds;
    }

    public void addSubtaskId(int subtaskId) {
        this.subtaskIds.add(subtaskId);
    }

    public void removeSubtaskId(int subtaskId) {
        this.subtaskIds.remove(Integer.valueOf(subtaskId));
    }

    // Переопределение метода toString информации об эпике
    @Override
    public String toString() {
        return "Epic{" +
                "subtaskIds=" + subtaskIds +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
