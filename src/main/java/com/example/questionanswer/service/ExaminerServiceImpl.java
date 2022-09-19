package com.example.questionanswer.service;

import com.example.questionanswer.entity.Question;
import com.example.questionanswer.exceptions.LargeNumberOfQuestions;
import com.example.questionanswer.interfaces.ExaminerService;
import com.example.questionanswer.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    QuestionService questionService;

    public ExaminerServiceImpl( QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size() || amount <= 0) {
            throw new LargeNumberOfQuestions("Превышена длинна массива");
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}