package co.com.sofka.questions;

import co.com.sofka.questions.model.AnswerDTO;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.AnswerRepository;
import co.com.sofka.questions.usecases.AddAnswerUseCase;
import co.com.sofka.questions.usecases.CreateUseCase;
import co.com.sofka.questions.usecases.DeleteUseCase;
import co.com.sofka.questions.usecases.GetUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

@SpringBootTest
class QuestionsApplicationTests {
    @Autowired
    CreateUseCase createUseCase;

    @Autowired
    AddAnswerUseCase addAnswerUseCase;
    @Autowired
    GetUseCase getUseCase;

    @Autowired
    DeleteUseCase deleteUseCase;

    @Test
    @DisplayName("Create question and answer")
    void createQuestionAndAnswer() {
        var question = new QuestionDTO(
                "fffxxxx", "¿My question is ...?", "OPEN", "Developer Software"
        );
        StepVerifier.create(createUseCase.create(question))
                .assertNext(question::setId)
                .verifyComplete();

        StepVerifier.create(addAnswerUseCase.addAnswer(question.getId(), new AnswerDTO(
                question.getId(), "dddd", "my resposnse")))
                .expectNextCount(1)
                .expectComplete()
                .verify();

        StepVerifier.create(getUseCase.get(question.getId()))
                .expectNextCount(1)
                .expectComplete()
                .verify();

        StepVerifier.create(deleteUseCase.delete(question.getId()))
                .expectComplete()
                .verify();
    }



}
