package miu.lab10.service;

import miu.lab10.model.Classroom;
import miu.lab10.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student save(Student s);
    List<Student> getPassingStudentsOnly();
    List<Student> getLatestStudents();
    void updateStudent(Classroom classroom, Integer studentId);
    Student getStudentById(Integer studentId);
    void deleteStudentById(Integer studentId);
    Student updateStudent(Student student,Integer studentId);
}
