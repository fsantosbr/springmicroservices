package br.com.brq.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
	
	@GetMapping("meu-primeiro-controller")
	public String minhaPrimeiraMensagem() {
		return "OK";
	}
	
	@GetMapping("meu-segundo-controller")
	public ArrayList<String> minhaSegundaMensagem(){
		ArrayList<String> meuArray = new ArrayList<>();
		meuArray.add("Olá1");
		meuArray.add("Olá2");
		return meuArray;
	}

}
