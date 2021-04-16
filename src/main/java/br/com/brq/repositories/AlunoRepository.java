package br.com.brq.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brq.models.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Integer> {
	
	List<AlunoModel> findByNomeContains(String nomeAluno);
	
//	@Modifying
//	@Transactional
//	@Query (value = "DELETE FROM aluno where matricula = :matricula", nativeQuery = true)
//	void deleteAlunoByMatricula(@Param("matricula") int matricula);

}
