package main.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.root.model.Professor;

//import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
//    Professor addProfessor(Professor professor);
}
