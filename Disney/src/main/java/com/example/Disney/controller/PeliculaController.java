package com.example.Disney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Disney.dto.PeliculaDto;
import com.example.Disney.entity.Pelicula;
import com.example.Disney.service.IPeliculaService;

@RestController
@RequestMapping("/pelicula")
@CrossOrigin("*")
public class PeliculaController {
	

	
	@Autowired
	private IPeliculaService peliculaService;
	
	@PostMapping
	public ResponseEntity<?> SavePelicula(@RequestBody PeliculaDto peliculaDto){
	Pelicula pelicula = peliculaService.savePelicula(peliculaDto);
	return new ResponseEntity<>(pelicula, HttpStatus.ACCEPTED);		
				
	}
	
	
	@GetMapping
	public ResponseEntity<?> findAllPelicula(){
		 return new ResponseEntity<>(peliculaService.findAll(), HttpStatus.OK);
		 
		 	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?>updatePelicula(@PathVariable(value= "id") Long id, @RequestBody PeliculaDto peliculaDto){
		return new ResponseEntity<>(peliculaService.update(id, peliculaDto), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	 public ResponseEntity<?> deletePelicula(@PathVariable(value = "id") Long id){
		peliculaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
		
	}
