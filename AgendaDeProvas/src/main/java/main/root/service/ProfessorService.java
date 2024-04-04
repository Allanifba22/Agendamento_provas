package main.root.service;

import java.util.List;
import java.util.Optional;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import main.root.controller.ProfessorController;
import main.root.model.Professor;
import main.root.repository.ProfessorRepository;

@Service
public class ProfessorService{

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor addProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }
    
    public Optional<Professor> find_by_id(long id) {
        return professorRepository.findById(id);
    }
  
}
