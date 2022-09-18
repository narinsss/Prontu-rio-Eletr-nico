package com.br.ProntuarioEletronico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ProntuarioEletronico.Repository.AtendimentoRepository;
import com.br.ProntuarioEletronico.model.Atendimento;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/atendimento")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AtendimentoController {
	
	@Autowired
	private AtendimentoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Atendimento>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Atendimento> getId(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/queixa/{queixa}")
	public ResponseEntity<List<Atendimento>> getQueixa(@PathVariable String queixa){
		return ResponseEntity.ok(repository.findAllByQueixaContainingIgnoreCase(queixa));
	}
	
	@PostMapping
	public ResponseEntity<Atendimento> post(@RequestBody Atendimento atendimento){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(atendimento));
	}
	@PutMapping
	public ResponseEntity<Atendimento> put(@RequestBody Atendimento atendimento){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(atendimento));
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	public AtendimentoRepository getRepository() {
		return repository;
	}

	public void setRepository(AtendimentoRepository repository) {
		this.repository = repository;
	}


}
