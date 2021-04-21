package com.ipsas.GestionDeFormations.Services;

import com.ipsas.GestionDeFormations.Exceptions.StudentNotFoundException;
import com.ipsas.GestionDeFormations.Models.*;
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


    public List<Student> addStudents(List<Student> studentList){
        for (Student student : studentList)
        {
            student.setUserCode(UUID.randomUUID().toString());
        }
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


    public Student joinGroupe(Student E,Groupe g){
        E.setGroupe(g);
        return studentRepo.save(E);
    }

    public List<Note> getNotes(Student E){
        return E.getListNote();
    }

    public double getMoyenne(Student E){
        double sum = 0;
        List<Note> listdesnotes = E.getListNote();
        for (Note item:listdesnotes) {
            sum += item.getMoyenne();

        }
        return sum/ listdesnotes.size();
    }

    public double getTauxDePresenceParMatiere(Student E, Matiere M){
        double sum = 0;
        List<Seance> seanceList = M.getListSeance();
        for (Seance s:seanceList) {
            List<FichePresence> fichePresenceList = s.getListFichePresence();
            for (FichePresence f:fichePresenceList) {
                if ((f.getStudent().equals(E))&&(f.isPresence())) {
                    sum += 1;
                }
            }
        }
        return sum / seanceList.size()*100;
    }
}
