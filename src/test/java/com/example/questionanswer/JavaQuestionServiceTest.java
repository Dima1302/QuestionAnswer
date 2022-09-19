package com.example.questionanswer;

import com.example.questionanswer.entity.Question;
import com.example.questionanswer.exceptions.QuestionAlreadyAddedException;
import com.example.questionanswer.exceptions.QuestionNotFoundException;
import com.example.questionanswer.interfaces.QuestionService;
import com.example.questionanswer.service.JavaQuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


public class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();

    @AfterEach
    public void afterEach() {
      Collection<Question>questions =  questionService.getAll();
      questions.forEach(questionService::remove);
    }

    @Test
    public void addNegativeTest() {
        Assertions.assertThat(questionService.getAll()).isEmpty();
        Question expected = addOneQuestion();

        assertThatExceptionOfType(QuestionAlreadyAddedException.class)
                .isThrownBy(()-> questionService.add(expected));

    }



    @Test
    public void addTest() {
        Assertions.assertThat(questionService.getAll()).hasSize(0);

        Question expected1 = new Question("Q1","A1");
        Question expected2 = new Question("Q2","A2");
        questionService.add(expected1);
        questionService.add(expected2.getQuestion(),expected2.getAnswer());

        Assertions.assertThat(questionService.getAll()).hasSize(2);
        Assertions.assertThat(questionService.getAll()).contains(expected1,expected2);
    }






    @Test
    public void deleteTest() {
        Assertions.assertThat(questionService.getAll()).isEmpty();
        Question expected = addOneQuestion();

        assertThatExceptionOfType(QuestionNotFoundException.class).isThrownBy(()->questionService.remove(new Question("Q2","A2")));
        questionService.remove(expected);
        Assertions.assertThat(questionService.getAll().isEmpty());
    }

    private Question addOneQuestion() {
        return addOneQuestion("Q1","A1");
    }

    @Test
    public void getRandomQuestionTest() {
        Assertions.assertThat(questionService.getAll()).isEmpty();

        int size = 5;
        for (int i = 1; i <= size ; i++) {
            addOneQuestion("Q" + i, "A" + i);
        }
        Assertions.assertThat(questionService.getAll()).hasSize(size);
        Assertions.assertThat(questionService.getRandomQuestion()).isIn(questionService.getAll());
    }

    private Question addOneQuestion (String question, String answer) {
        int size = questionService.getAll().size();

        Question expected = new Question(question,answer);
        questionService.add(expected);

        Assertions.assertThat(questionService.getAll()).hasSize(size + 1);
        Assertions.assertThat(questionService.getAll()).contains(expected);
        return expected;
    }







}
