package miu.lab10.controller;

import miu.lab10.model.Student;
import miu.lab10.model.Transcript;
import miu.lab10.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
@Controller
@RequestMapping(value = {"/student"})
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView listStudents() {
        var modelAndView = new ModelAndView();
        var students = studentService.getAllStudents();
        modelAndView.addObject("students", students);
        modelAndView.addObject("studentsCount", ((List)students).size());
        modelAndView.setViewName("secured/studentlist");
        return modelAndView;

    }
    @GetMapping(value = {"/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student(null,null,null,null));
        return "secured/studentnew";
    }
    @PostMapping(value = {"/new"})
    public String registerNewStudent(@Valid @ModelAttribute("student") Student student,
                                       BindingResult bindingResult, Model model) {

        studentService.save(student);
        return "redirect:/student/list";
    }
    @GetMapping(value = {"/edit/{studentId}"})
    public String editStudent(@PathVariable Integer studentId, Model model) {
        var student = studentService.getStudentById(studentId);
        model.addAttribute("student",student);
        return "secured/studentedit";
    }

    @PostMapping(value = {"/update"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                  BindingResult bindingResult, Model model) {
        studentService.save(student);
        return "redirect:/student/list";
    }

    @GetMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        studentService.deleteStudentById(studentId);
        return "redirect:/student/list";
    }





}
