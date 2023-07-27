package com.example.examserver.Controller;

import com.example.examserver.model.exam.Question;
import com.example.examserver.model.exam.Quiz;
import com.example.examserver.services.QuestionService;
import com.example.examserver.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question)
    {
        Question question1 = this.questionService.addQuestion(question);
        return  ResponseEntity.ok(question1);
    }


    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable("questionId") Long questionId)
    {
        return this.questionService.getQuestion(questionId);
    }


    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("quizId") Long quizId)
    {
//        Quiz quiz=new Quiz();
//        quiz.setqId(quizId);
//        return ResponseEntity.ok(this.questionService.getQuestionsOfQuiz(quiz));
        Quiz quiz = this.quizService.getQuiz(quizId);
        Set<Question> questions = quiz.getQuestions();
        List<Question> list=new ArrayList<>(questions);
        if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions()))
        {
            list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()));
        }
        list.forEach((q)->{
            q.setAnswer("");
        });
        Collections.shuffle(list);
        return ResponseEntity.ok(list);

    }

    @GetMapping("/quiz/all/{quizId}")
    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("quizId") Long quizId)
    {
        Quiz quiz=new Quiz();
        quiz.setqId(quizId);
        Set<Question> questionOfQuiz=this.questionService.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionOfQuiz);
    }

    @PutMapping("/")
    public Question updateQuestion(@RequestBody Question question)
    {
        return this.questionService.updateQuestion(question);
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") Long questionId)
    {
        this.questionService.deleteQuestion(questionId);
    }

    //evaluate quiz
    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions)
    {
        double marksGot=0;
        Integer correctAnswers=0;
        Integer attempted=0;
        double totalMarks=0;

        for(Question q :questions){
            Question question=this.questionService.getQuestionById(q.getQuestionId());
            double marksSingle=Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
            totalMarks+=marksSingle;
            if (question.getAnswer().trim().equals(q.getGivenAnswer()))
            {
                correctAnswers++;
                marksGot+=marksSingle;
            }
            if(q.getGivenAnswer()!=null)
            {
                attempted++;
            }
        }
        Integer wrongAnswers=attempted-correctAnswers;
        Integer unattempted= questions.size()-attempted;
        Map<Object,Object> map=Map.of("marksGot",marksGot,
                "totalQuestion",questions.size(),
                "totalMarks",totalMarks,
                "correctAnswers",correctAnswers,
                "wrongAnswers",wrongAnswers,
                "attempted",attempted,
                "unattempted",unattempted);
        return ResponseEntity.ok(map);
    }
}
