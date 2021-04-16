package br.com.brq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brq.models.TipoCliente;

@Repository
public interface TipoClienteRepository extends JpaRepository<TipoCliente, String> {
	
}
