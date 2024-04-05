package main.root.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import main.root.model.Professor;
import main.root.repository.ProfessorRepository;
import main.root.service.ProfessorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;
    
    @PostMapping
    public ResponseEntity<Professor> salvarProfessor(@RequestBody Professor professor) {
		Professor novoProfessor = professorService.addProfessor(professor);
		
		if (novoProfessor != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(novoProfessor);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping
    public List<Professor> getAllProfessor() {
    	List<Professor> listaProfessores = professorService.listarProfessores();
    	for (Professor p : listaProfessores){
    		System.out.println(p.getNome());
    	}
    	return listaProfessores;
    }
    
    @GetMapping("/{id}")
    public Optional<Professor> getProfessorById(@PathVariable Long id) {
    	return professorService.find_by_id(id);
    }

	
}

