package co.com.sofka.questions.services;

import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@Service
@Validated
public class QuestionService {
    private final QuestionRepository repository;

    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public Mono<String> create(@Valid QuestionDTO newQuestion) {

        var question = new Question();
        question.setCategory(newQuestion.getCategory());
        question.setQuestion(newQuestion.getQuestion());
        question.setUserId(newQuestion.getUserId());
        question.setType(newQuestion.getType());

        return repository.save(question).map(Question::getId);
    }

    public Mono<QuestionDTO> getQuestionBy(String id) {
        return repository.findById(id)
                .map(entity -> new QuestionDTO(
                        entity.getId(), entity.getUserId(), entity.getQuestion(), entity.getType(), entity.getCategory()
                ));
    }

    public Mono<Void> deleteQuestion(String id) {
        return repository.deleteById(id);
    }

}
