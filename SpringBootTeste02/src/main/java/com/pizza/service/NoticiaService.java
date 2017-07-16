package com.pizza.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.model.Noticia;
import com.pizza.repository.NoticiaRepository;

@Service
public class NoticiaService {

	@Autowired
	public NoticiaRepository noticiaRepository; 
	
	public List<Noticia> findAll(){
		return noticiaRepository.findAll();
	}
	
	public Noticia save(Noticia noticia){
		if(noticia.getDataHoraCadastro() == null){
			noticia.setDataHoraCadastro(new Date());
		}
		return noticiaRepository.save(noticia);
	}
	
	public Noticia findById(Long id){
		Noticia response = noticiaRepository.findOne(id);
		if(response == null){
			response = new Noticia();
		}
		return response;
	}
	
	public Noticia delete(Long id){
		Noticia noticia = noticiaRepository.findOne(id);
		noticia.setAtivo(false);
		return noticiaRepository.save(noticia);
	}
}
