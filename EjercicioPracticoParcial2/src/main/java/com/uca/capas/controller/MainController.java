package com.uca.capas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;

@Controller
public class MainController {
	
	@Autowired
	private ImportanciaDAO importanciaDAO;
	
	@Autowired
	private ContribuyenteDAO contribuyenteDAO;
	
	@RequestMapping("/index")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Importancia>  importancia = null;
		Contribuyente contribuyente = new Contribuyente();
		try {
			importancia = importanciaDAO.findAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("importancia", importancia);
		mav.addObject("contribuyente", contribuyente);
		mav.setViewName("Index");
		return mav;
		
	}
	@RequestMapping(value="/insertar", method=RequestMethod.POST)
	public ModelAndView insertar(@ModelAttribute Contribuyente contribuyente) {
		ModelAndView mav = new ModelAndView();
		try {
			
			//Encontrar importancia seleccionada
			Importancia importancia = importanciaDAO.findOne(contribuyente.getCodigoImportancia());
			//Setear importancia seleccionada en contribuyente
			contribuyente.setImportancia(importancia);
			//Parsear string date del html a date java
			Date date = new Date();
			contribuyente.setFecha(date);
			contribuyenteDAO.insertar(contribuyente);
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("contribuyente", contribuyente);
		mav.setViewName("Exito");
		
		return mav;
	}
	//Mostrar lista de Estudiantes
	@RequestMapping("/listado")
	public ModelAndView initMain2() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente>  contribuyente = null;
		try {
			contribuyente = contribuyenteDAO.findAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("contribuyente", contribuyente);
		mav.setViewName("listado");
		return mav;
		
	}
	

}
