package co.com.sofka.questions;

import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.QuestionRepository;
import co.com.sofka.questions.services.QuestionService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import reactor.test.StepVerifier;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class QuestionsApplicationTests {
	@Autowired
	QuestionService questionService;
	private QuestionDTO question;

	@BeforeEach
	public void setup(){
		this.question = new QuestionDTO(
				"sss",  "sss",  "ssss",  "ssss"
		);
	}


	@Test
	@DisplayName("Validation CRUD for Service")
	void validationCRUDService() {
		StepVerifier.create(questionService.create(question))
				.expectNextMatches(id -> {
					question.setId(id);
					return id.length() > 10;
				})
				.verifyComplete();

		StepVerifier.create(questionService.getQuestionBy(question.getId()))
				.expectNext(question)
				.verifyComplete();

		StepVerifier.create(questionService.deleteQuestion(question.getId()))
				.verifyComplete();
	}



}
