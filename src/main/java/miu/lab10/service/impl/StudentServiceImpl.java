package miu.lab10.service.impl;

import miu.lab10.model.Classroom;
import miu.lab10.model.Student;
import miu.lab10.repository.StudentRepository;
import miu.lab10.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Saves Student data
     * @param s Student data object to be saved
     * @return saved student data object
     */
    @Override
    public Student save(Student s) {
        return studentRepository.save(s);
    }

    @Override
    public List<Student> getPassingStudentsOnly() {
        return studentRepository.findStudentsWithCgpaGreaterThan3(3.0f);
    }

    @Override
    public List<Student> getLatestStudents() {
        return studentRepository.findStudentsByStudentNumberGreaterThan(980002);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public void updateStudent(Classroom classroom, Integer studentId) {
        studentRepository.update(classroom, studentId);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudent(Student student, Integer studentId) {
        return studentRepository.save(student);
    }
}
