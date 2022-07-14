package miu.lab10.controller;

import miu.lab10.model.Student;
import miu.lab10.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.Flow;

@RestController
@RequestMapping(value="student/api")
public class StudentRestController {
    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/list")
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/{studentId}")
    public Student getStudentById(@PathVariable Integer studentId ){
        return studentService.getStudentById(studentId);
    }

    @PostMapping(value = "/new")
    public Student addNewStudent( @Valid @RequestBody Student student){
        return studentService.save(student);
    }

    @PutMapping(value = "/update/{studentId}")
    public Student updateStudent (@Valid @RequestBody Student student, @PathVariable Integer studentId){
        return studentService.updateStudent(student,studentId);
    }

    @DeleteMapping(value = "/delete/{studentId}")
    public void deleteStudent(@PathVariable Integer studentId){
        studentService.deleteStudentById(studentId);
    }



}
