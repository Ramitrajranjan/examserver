package com.example.examserver.services;

import com.example.examserver.model.exam.Question;
import com.example.examserver.model.exam.Quiz;

import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestions();
    public Question getQuestion(Long questionId);
    public void deleteQuestion(Long questionId);
    public Question getQuestionById(Long questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);
}
