package br.com.brq.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brq.models.MateriaModel;

@Repository
public interface MateriaRepository extends JpaRepository<MateriaModel, Integer>{
	
	List<MateriaModel> findByNomeContains(String nomeMat);	
	
	Page<MateriaModel> findAllByNomeContains(String nome, Pageable page);

	/*
	 * - findByNome = It creates a query that find an object using the field Nome
	 * - findByNomeContains = It creates a query that find an object using the Nome field and the SQL operator 'like'..
	 *  	which means any String that contains the parameter in the middle.
	 * -  @Query (value = "SELECT * FROM materia where nome like %:nome%", nativeQuery = true)
	 * 		Using this annotation above the method, allow us to make a query. it must use the following '(@Param("nome") String nome)' parameter in the method
	
	*/
	
	/* SELECT * FROM materia where nome = <nome> */
	// @Query (value = "SELECT * FROM materia where nome like %:nome%", nativeQuery = true)
	// List<MateriaModel> findByNomeContains(@Param("nome") String nome);

}
