import java.util.UUID;

public class TodoItem {
    private String name;
    private Priority priority;
    private UUID id;

    public TodoItem(String name, Priority priority, UUID id) {
        setName(name);
        setPriority(priority);
        setId(id);
    }

    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.name, this.priority.getValue(), this.id);
    }

    public enum Priority {
        HIGH("high"),
        LOW("low"),
        MEDIUM("medium");

        private final String value;

        Priority(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}

