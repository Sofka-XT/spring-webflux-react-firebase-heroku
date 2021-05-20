package co.com.sofka.questions.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Question {
    @Id
    private String id;
    private String userId;
    private String question;
    private String type;
    private String category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Objects.requireNonNull(id, "id id is required");
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = Objects.requireNonNull(userId, "user id is required");
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = Objects.requireNonNull(question, "question is required");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = Objects.requireNonNull(type, "type is required");
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = Objects.requireNonNull(category, "category is required");
    }
}
