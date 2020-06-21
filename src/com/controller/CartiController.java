package com.controller;

import java.sql.SQLException;
import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CartiDAO;
import com.pojo.Carti;

@Controller
@RequestMapping("carti")
public class CartiController {

	@RequestMapping(value="lista.htm")
	public ModelAndView afisareCarti() throws SQLException {
		
		
		LinkedList<Carti> carti = CartiDAO.getAllCarti();
		ModelMap model = new ModelMap();
		model.put("carti", carti);	
		return new ModelAndView("/WEB-INF/carti/lista.jsp", "model", model);		
	}
	
	@RequestMapping(value="detalii.htm")
	public ModelAndView afisareDetalii(@RequestParam Integer id) throws SQLException {
		Carti c = CartiDAO.getCartiById(id);
		ModelMap model=new ModelMap();
		model.put("carti", c);
		return new ModelAndView("/WEB-INF/carti/detalii.jsp", "model", model);
	}
	
	@RequestMapping(value="edit.htm")
	public ModelAndView carteEdit(@RequestParam Integer id, Model model) throws SQLException {
		Carti c = CartiDAO.getCartiById(id);
		model.addAttribute("cartiForm", c);
		return new ModelAndView("/WEB-INF/carti/edit.jsp", "model", model);
	}
	
	@RequestMapping(value="save.htm", method = RequestMethod.POST)
	public ModelAndView saveCarti(@ModelAttribute("cartiForm") Carti carti, ModelMap model, BindingResult result) {
		model.put("mesaj", "");
		Carti carteiObj;
		
		try {
			carteiObj = CartiDAO.getCartiById(carti.getId());
			carteiObj.setTitlu(carti.getTitlu());
			carteiObj.setData_publicarii(carti.getData_publicarii());
			carteiObj.setNumar_pagini(carti.getNumar_pagini());
			CartiDAO.updateCarti(carteiObj);
			model.put("cartiForm", carti);
			model.put("mesaj", "Cartea a fost Salvata");
		} catch(NumberFormatException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("/WEB-INF/carti/edit.jsp", "model", model);
	}
	
	@RequestMapping(value = "/delete.htm")
	public ModelAndView deleteCarte(@RequestParam Integer id, Model model) throws NumberFormatException, SQLException {
		
		CartiDAO.deleteCarte(id);
		LinkedList<Carti> carti = CartiDAO.getAllCarti();
		model.addAttribute("carti", carti);
		return new ModelAndView("/WEB-INF/carti/lista.jsp", "model", model);
	}
	
	@RequestMapping(value = "/add.htm")
	public ModelAndView adaugaCarte(Model model) throws NumberFormatException, SQLException {
		Carti carti = new Carti();
		model.addAttribute("cartiForm", carti);
		return new ModelAndView("/WEB-INF/carti/add.jsp", "model", model);
	}
	
	@RequestMapping(value = "/add-save", method = RequestMethod.POST)
	public ModelAndView addCarti(@ModelAttribute("cartiForm") Carti carti, ModelMap model, BindingResult result) {
		
		try {
			CartiDAO.insert(carti);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/carti/lista.htm");
	}
	
}
