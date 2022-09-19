package com.example.questionanswer.controller;

import com.example.questionanswer.entity.Question;
import com.example.questionanswer.interfaces.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaController  {
    private final QuestionService questionService;

    public JavaController(QuestionService service) {
        this.questionService = service;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return questionService.add(question,answer);
    }


    @GetMapping("/remove")
    public  Question removeQuestion (@RequestParam String question,
                                     @RequestParam String answer) {

        return questionService.remove(questionService.add(question,answer));
    }


    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

}


