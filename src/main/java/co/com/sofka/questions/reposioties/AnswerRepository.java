package co.com.sofka.questions.reposioties;

import co.com.sofka.questions.collections.Answer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends ReactiveCrudRepository<Answer, String> {
}
