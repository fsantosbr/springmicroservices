package br.com.brq.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // cria o constructor com todos os argumentos
@NoArgsConstructor // cria o constructor sem argumento
@Entity
@Table(name = "tbtipocli")
public class TipoCliente {
	
	@Id
	private String codtipocli;
	private String desctipocli;
	
}
