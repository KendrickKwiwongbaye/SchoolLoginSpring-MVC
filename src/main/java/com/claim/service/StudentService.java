package com.claim.service;


import com.claim.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //Lets you know the business logic is added to this class
public class StudentService {


    private List<Student> students = new ArrayList<>();


    //add students to the database
    public void saveStudent(Student s1){
        students.add(s1);
    }

    public List<Student> getStudents(){
        return students;
    }

    public boolean findStudent(Student s1) {
        for (int i = 0; i < students.size(); i++) {
            if (s1.getEmail().equals(students.get(i).getEmail()) && s1.getPassword().equals(students.get(i).getPassword())) {
                return false;
            }
        }
        return true;
    }

}



