package com.students.studentProfile.controller;

import com.students.studentProfile.model.Student;
import com.students.studentProfile.service.StudentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing student data.
 */

@RestController
@RequestMapping("students")
public class StudentData {

    private static final Logger logger = LoggerFactory.getLogger(StudentData.class);

    @Autowired
    private StudentService service;


    /**
     * Get all students.
     * @return List of students.
     */
    @GetMapping
    public List<Student> getAllStudents(){
        logger.info("inside get all students");
        return service.getAllStudents();
    }


    /**
     * Create a new student.
     * @param newStudent Student object to be created.
     * @return Success flag.
     */
    @PostMapping
    public boolean createStudent(@Valid @RequestBody Student newStudent){
        logger.info("inside create student");
        return service.createStudent(newStudent);
    }

    /**
     * Get student by ID.
     * @param studentId ID of the student.
     * @return Student object.
     */
    @GetMapping("id/{studentId}")
    public Student getStudentByID(@PathVariable("studentId") Integer studentId){
        logger.info("fetch student with id{}",studentId);
        return service.getStudentById(studentId);
    }

    /**
     * Update student details.
     * @param id ID of the student.
     * @param updatedEntry Updated student data.
     * @return Success message.
     */
    @PutMapping("id/{id}")
    public String updateStudentDetails(@PathVariable("id") Integer id , @RequestBody Student updatedEntry){
        logger.info("inside update student details");
        service.updateStudentById(id,updatedEntry);
        logger.info("updated student with ID: {}", id);
        return "Data updated successfully";
    }

    /**
     * Delete student details.
     * @param studentId ID of the student.
     * @return Deleted student object.
     */
    @DeleteMapping("id/{studentId}")
    public Student deleteStudentDetail(@PathVariable("studentId") Integer studentId){
        logger.info("Deleting student with ID: {}", studentId);
        return service.deleteStudent(studentId);
    }

}

