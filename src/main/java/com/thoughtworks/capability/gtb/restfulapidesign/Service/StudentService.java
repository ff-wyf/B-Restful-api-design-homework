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

    public void delStudentById(Integer id) {
        int beforeDelLength = StudentList.studentList.size();
        StudentList.studentList = StudentList.studentList.stream().filter(stu -> stu.getId() != id).collect(Collectors.toList());
        int afterDelLength = StudentList.studentList.size();
        if (beforeDelLength == afterDelLength) {
            throw new StudentException("学生不存在");
        }
    }

    public List<Student> getStudentsByGender(String gender) {
        if (StudentList.studentList.size() == 0) {
            throw new StudentException("学生列表为空，请增加学生");
        }
        if (gender == null) {
            return StudentList.studentList;
        }
        List<Student> resultList = StudentList.studentList.stream().filter(stu -> stu.getGender().equals(gender)).collect(Collectors.toList());
        if (resultList.size() == 0) {
            throw new StudentException("暂无性别为:" + gender+ "的学生");
        }
        return resultList;
    }

    public Student getStudentById(Integer id) {
        List<Student> studentList = StudentList.studentList.stream().filter(stu -> stu.getId() == id).collect(Collectors.toList());
        if (studentList.size() == 0) {
            throw new StudentException("该学生不存在");
        }
        return studentList.get(0);
    }

    public void updateStudents(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); ++i) {
            boolean isFind = false;
            for (int j = 0; j < StudentList.studentList.size(); ++j) {
                if (StudentList.studentList.get(j).getId() == studentList.get(i).getId()) {
                    StudentList.studentList.get(j).setGender(studentList.get(i).getGender());
                    StudentList.studentList.get(j).setName(studentList.get(i).getName());
                    StudentList.studentList.get(j).setNote(studentList.get(i).getNote());
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                throw new StudentException("id为:" + studentList.get(i).getId() + "的学生不存在");
            }
        }
    }
}
