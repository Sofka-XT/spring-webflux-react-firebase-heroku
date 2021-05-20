package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Objects;

@Service
@Validated
public class UpdateUseCase {
    private final QuestionRepository questionRepository;
    private final MapperUtils mapperUtils;

    public UpdateUseCase(MapperUtils mapperUtils, QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
        this.mapperUtils = mapperUtils;
    }

    public Mono<String> update(String id, @Valid QuestionDTO dto) {
        Objects.requireNonNull(id, "Id of the question is required");
        return questionRepository
                .save(mapperUtils.mapperToQuestion(id).apply(dto))
                .map(Question::getId);
    }


}
