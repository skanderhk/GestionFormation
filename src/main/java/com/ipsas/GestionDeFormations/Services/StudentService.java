package com.ipsas.GestionDeFormations.Services;

import com.ipsas.GestionDeFormations.Exceptions.StudentNotFoundException;
import com.ipsas.GestionDeFormations.Models.*;
import com.ipsas.GestionDeFormations.Repositories.MatiereRepository;
import com.ipsas.GestionDeFormations.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepo;
    private final MatiereRepository matiereRepo;

    @Autowired
    public StudentService(StudentRepository studentRepo, MatiereRepository matiereRepo) {
        this.studentRepo = studentRepo;
        this.matiereRepo = matiereRepo;
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

    public double getTauxDePresenceParMatiere(Student student, Matiere matiere){
        Student E = this.studentRepo.getOne(student.getId());
        Matiere M = this.matiereRepo.getOne(matiere.getId());
        List<Seance> seanceList = M.getListSeance();
        double sum = 0;
        for (Seance seance:seanceList) {
            List<FichePresence> fichePresenceList = seance.getListFichePresence();
            for (FichePresence fichePresence:fichePresenceList) {
                if ( (fichePresence.isPresence()) && (fichePresence.getStudent().getId().equals(E.getId())) ){
                    sum += 1;
                }
            }

        }
        return sum *100 / M.getListSeance().size();
    }
}

