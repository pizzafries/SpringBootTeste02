package com.pizza.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.model.Noticia;
import com.pizza.service.NoticiaService;

@RestController
@ComponentScan
public class NoticiaController {

	@Autowired
	private NoticiaService noticiaService;

	@RequestMapping(path="/", method=RequestMethod.GET)
    public @ResponseBody List<Noticia> findAll(){
    	return noticiaService.findAll();
    }
	
    @RequestMapping(path="/hello", method=RequestMethod.GET)
    public @ResponseBody String greeting() {
    	String msg = new String("Hello mate");
        return msg;
    }
    
    @RequestMapping(path="/", method=RequestMethod.POST)
    public @ResponseBody Map<String, Object> save(@RequestBody @Valid Noticia noticia, BindingResult result){
    	Map<String, Object> response = new HashMap<>();
    	if(result.hasErrors()){
    		response.put("error",result.getFieldErrors());
    		return response;
    	}
    	response.put("value", noticiaService.save(noticia));
    	return response;
    }
    
    @RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Noticia findById(@PathVariable(value="id") Long id){
		return noticiaService.findById(id);
	}
    
    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    public Map<String,Object> delete(@PathVariable("id") Long id){
    	Map<String, Object> response = new HashMap<>();
    	if(noticiaService.delete(id) != null){
    		response.put("sucess","200");
    	}else{
    		response.put("error", "400");
    	}
    	return response;
    }
}
