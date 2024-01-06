package br.com.mateuslima.ensolverschallenge.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "notes")
public class UserNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private boolean confirmed;
    private int priority;
    private String category;


    public UserNotes(String name, String description, boolean confirmed, int priority, String category) {
        this.name = name;
        this.description = description;
        this.confirmed = confirmed;
        this.priority = priority;
        this.category = category;
    }

    public UserNotes(String name, String description, boolean confirmed, int priority) {
        this.name = name;
        this.description = description;
        this.confirmed = confirmed;
        this.priority = priority;

    }
    public UserNotes() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
