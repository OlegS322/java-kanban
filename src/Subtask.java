// Класс для подзадач
public class Subtask extends Task {
    private int epicId; // Идентификатор эпика, к которому относится подзадача

    // Конструктор класса Subtask
    public Subtask(String title, String description, int id, TaskStatus status, int epicId) {
        super(title, description, id, status);
        this.epicId = epicId;
    }

    // Геттеры и сеттеры
    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }

    // Переопределение метода toString вывода информации о подзадаче
    @Override
    public String toString() {
        return "Subtask{" +
                "epicId=" + epicId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
