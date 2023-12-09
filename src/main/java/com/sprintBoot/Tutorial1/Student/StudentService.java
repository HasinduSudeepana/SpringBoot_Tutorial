package com.sprintBoot.Tutorial1.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private static StudentReporsitory studentReporsitory = null;

    @Autowired
    public StudentService(StudentReporsitory studentReporsitory) {
        StudentService.studentReporsitory = studentReporsitory;
    }

    public List<Student> getStudents(){
        return studentReporsitory.findAll();
    }

    public static void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentReporsitory.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentReporsitory.save(student);
    }


    public void deleteStudent(Long studentId) {
        boolean exists = studentReporsitory.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with id"+ studentId + "does not exists");
        }
        studentReporsitory.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student= studentReporsitory.findById(studentId).
                orElseThrow(()-> new IllegalStateException("Student with id"+studentId+"does not exists"));
        if(name !=null && name.length()>0  && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email !=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional= studentReporsitory.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            student.setEmail(email);
        }
    }


}
