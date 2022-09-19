package com.example.questionanswer.service;

import com.example.questionanswer.entity.Question;
import com.example.questionanswer.exceptions.QuestionAlreadyAddedException;
import com.example.questionanswer.exceptions.QuestionNotFoundException;
import com.example.questionanswer.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> questions;

    private final Random random;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
        this.random = new Random();
    }

    public  Question add(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }


    public Question add(Question question) {
        if (!questions.add(question)) {
            throw new QuestionAlreadyAddedException("Вопрос присутсвует в коллекции");
        }
        return question;
    }


    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new QuestionNotFoundException("Вопрос не найден в коллекции");
        }
        return question;
    }



    public Collection<Question> getAll() {
        return  Collections.unmodifiableCollection(new HashSet<>(questions));
    }


    public Question getRandomQuestion() {
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));

    }
}

