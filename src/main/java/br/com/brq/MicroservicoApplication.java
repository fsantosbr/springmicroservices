package br.com.brq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.brq.models.MateriaModel;

@SpringBootApplication
public class MicroservicoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		MateriaModel m = new MateriaModel();
		m.setNome("Matéria 1");
		
		//Builder
		MateriaModel m1 = MateriaModel
				.builder()
				.nome("Materia 1")
				.professor("PRof 1")
				.build();
		
		

	}

}
