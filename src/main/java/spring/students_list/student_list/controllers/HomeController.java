package spring.students_list.student_list.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.students_list.student_list.db.DBManager;
import spring.students_list.student_list.db.Student;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String index(Model model){
        ArrayList<Student> students = DBManager.getStudents();
        model.addAttribute("students", students);
        return "index";
    }

    @PostMapping(value = "addStudent")
    public String addStudent(@RequestParam(name = "name", defaultValue = "No Item") String name,
                             @RequestParam(name = "surname", defaultValue = "0") String surname,
                             @RequestParam(name = "exam", defaultValue = "0") int exam){
        String mark = "";
        if(exam >= 50 && exam <= 59){
            mark = "D";
        }
        else if(exam >= 60 && exam <= 74){
            mark = "C";
        }
        else if(exam >= 75 && exam <= 89){
            mark = "B";
        }
        else if(exam >= 90){
            mark = "A";
        }
        else{
            mark = "F";
        }
        DBManager.addStudent(new Student(null, name,surname,exam,mark));
        return "redirect:/";
    }
    @GetMapping(value = "add-page")
    public String add_page(){
        return "addStudent";
    }
}
