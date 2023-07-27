package com.example.examserver.services.implementation;

import com.example.examserver.model.exam.Question;
import com.example.examserver.model.exam.Quiz;
import com.example.examserver.repository.QuestionRepository;
import com.example.examserver.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new LinkedHashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public void deleteQuestion(Long questionId) {
        Question question=new Question();
        question.setQuestionId(questionId);
        this.questionRepository.delete(question);
    }

    @Override
    public Question getQuestionById(Long questionId) {
        return this.questionRepository.getOne(questionId);
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {

        return this.questionRepository.findByQuiz(quiz);
    }
}