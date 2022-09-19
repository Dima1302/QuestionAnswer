package com.example.questionanswer.interfaces;

import com.example.questionanswer.entity.Question;

import java.util.Collection;

public interface ExaminerService{
    Collection<Question> getQuestions(int amount);

}
