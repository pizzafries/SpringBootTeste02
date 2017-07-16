package com.pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizza.model.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long>{

}
