package com.ipsas.GestionDeFormations.Services;

import com.ipsas.GestionDeFormations.Exceptions.StudentNotFoundException;
import com.ipsas.GestionDeFormations.Models.Groupe;
import com.ipsas.GestionDeFormations.Models.Student;
import com.ipsas.GestionDeFormations.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepo;

    @Autowired
    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student addStudent(Student E){
        E.setUserCode(UUID.randomUUID().toString());
        return studentRepo.save(E);
    }

    public Student joinGroupe(Student E,Groupe g){
        E.setGroupe(g);
        return studentRepo.save(E);
    }

    public List<Student> addStudents(List<Student> studentList){
        return studentRepo.saveAll(studentList);
    }

    public List<Student> findAll(){
        return studentRepo.findAll();
    }

    public Student findOneById(Long id){
        return studentRepo.findById(id).orElseThrow(()-> new StudentNotFoundException("Student by id : "+id+" is not found !" ));
    }

    public Student updateStudent(Student E){
        return studentRepo.save(E);
    }

    public void deleteStudent(Long id){
        studentRepo.deleteById(id);
    }

}
