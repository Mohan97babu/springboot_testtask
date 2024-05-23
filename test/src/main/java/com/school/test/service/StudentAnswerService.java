//package com.school.test.service;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.school.test.entity.Choice;
//import com.school.test.entity.Score;
//import com.school.test.entity.StudentAnswer;
//import com.school.test.repository.ChoiceRepository;
//import com.school.test.repository.ScoreRepository;
//import com.school.test.repository.StudentAnswerRepository;
//
//@Service
//public class StudentAnswerService {
//
//    @Autowired
//    private StudentAnswerRepository studentAnswerRepository;
//
//    @Autowired
//    private ChoiceRepository choiceRepository;
//
//    @Autowired
//    private ScoreRepository scoreRepository;
//
//    public Map<String, String> addStudentAnswer(final StudentAnswer studentAnswer) {
//        Map<String, String> response = new LinkedHashMap<>();
//
//        Optional<Choice> choiceOptional = choiceRepository.findById(studentAnswer.getChoice().getId());
//
//        if (choiceOptional.isPresent()) {
//            Choice existingChoice = choiceOptional.get();
//
//            if (existingChoice.getIsCorrect() == 1) {
//                Score score = studentAnswer.getScore();
//
//                if (score != null) {
//                    Optional<Score> scoreOptional = this.scoreRepository.findById(score.getId());
//
//                    if (scoreOptional.isPresent()) {
//                        Score existingScore = scoreOptional.get();
//                        existingScore.setScore(existingScore.getScore() + 1);
////                        existingScore.setStudent(existingScore.getStudent().getId()+"");
//                        scoreRepository.save(existingScore);
//                        response.put("message", "Score updated successfully.");
//                    } else {
//                        score.setScore(1); 
//                        scoreRepository.save(score);
//                        response.put("message", "Score saved successfully as a new entry.");
//                    }
//                } else {
//                    response.put("error", "Score information is missing in the student answer.");
//                }
//            } else {
//                response.put("message", "The choice is incorrect, no score updated.");
//            }
//        } else {
//            response.put("error", "Choice not found.");
//        }
//
//        return response;
//    }
//}
package com.school.test.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.test.entity.Choice;
import com.school.test.entity.Score;
import com.school.test.entity.Student;
import com.school.test.entity.StudentAnswer;
import com.school.test.entity.Test;
import com.school.test.repository.ChoiceRepository;
import com.school.test.repository.ScoreRepository;
import com.school.test.repository.StudentAnswerRepository;
import com.school.test.repository.StudentRepository;
import com.school.test.repository.TestRepository;

@Service
public class StudentAnswerService {

    @Autowired
    private StudentAnswerRepository studentAnswerRepository;

    @Autowired
    private ChoiceRepository choiceRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestRepository testRepository;

    public Map<String, String> addStudentAnswer(final StudentAnswer studentAnswer) {
        Map<String, String> response = new LinkedHashMap<>();

        Optional<Choice> choiceOptional = choiceRepository.findById(studentAnswer.getChoice().getId());

        if (choiceOptional.isPresent()) {
            Choice existingChoice = choiceOptional.get();

            if (existingChoice.getIsCorrect() == 1) {
                // Fetch or create the score for the student and test
                Student student = studentAnswer.getStudent();
                Test test = studentAnswer.getTest(); // Get test from payload

                Optional<Score> scoreOptional = scoreRepository.findByStudentAndTest(student, test);

                Score score;
                if (scoreOptional.isPresent()) {
                    score = scoreOptional.get();
                    score.setScore(score.getScore() + 1);
                } else {
                    score = new Score();
                    score.setStudent(student);
                    score.setTest(test);
                    score.setScore(1); // Initialize score
                }
                
                scoreRepository.save(score);
                response.put("message", "Score updated successfully.");
            } else {
                response.put("message", "The choice is incorrect, no score updated.");
            }
            
            studentAnswerRepository.save(studentAnswer);
        } else {
            response.put("error", "Choice not found.");
        }

        return response;
    }
}
