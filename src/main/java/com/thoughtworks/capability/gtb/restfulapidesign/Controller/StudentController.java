package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public ResponseEntity addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.ok("添加成功");
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delStudent(@PathVariable Integer id) {
        studentService.delStudentById(id);
        return ResponseEntity.ok("删除成功");
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudentsByGender(@RequestParam(required = false) String gender) {
        List<Student> studentList = studentService.getStudentsByGender(gender);
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }
}
