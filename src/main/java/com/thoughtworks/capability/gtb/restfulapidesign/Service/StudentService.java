package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Exception.StudentException;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.StudentList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    public void addStudent(Student student) {
        List<Student> existStudent = StudentList.studentList.stream().filter(stu -> stu.getId() == student.getId()).collect(Collectors.toList());
        if (existStudent.size() != 0) {
            throw new StudentException("学生已存在");
        }

        StudentList.studentList.add(student);
    }
}
