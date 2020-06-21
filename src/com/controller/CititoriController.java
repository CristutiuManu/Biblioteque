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

import com.dao.CititoriDAO;
import com.pojo.Cititori;

@Controller
@RequestMapping("cititori")
public class CititoriController {

	@RequestMapping(value="lista.htm")
	public ModelAndView afisareCititori() throws SQLException {
		
		
		LinkedList<Cititori> cititori = CititoriDAO.getAllCititori();
		ModelMap model = new ModelMap();
		model.put("cititori", cititori);	
		return new ModelAndView("/WEB-INF/cititori/lista.jsp", "model", model);		
	}
	
	@RequestMapping(value="detalii.htm")
	public ModelAndView afisareDetalii(@RequestParam Integer id) throws SQLException {
		Cititori c = CititoriDAO.getCititoriById(id);
		ModelMap model=new ModelMap();
		model.put("cititori", c);
		return new ModelAndView("/WEB-INF/cititori/detalii.jsp", "model", model);
	}
	
	@RequestMapping(value="edit.htm")
	public ModelAndView carteEdit(@RequestParam Integer id, Model model) throws SQLException {
		Cititori c = CititoriDAO.getCititoriById(id);
		model.addAttribute("cititoriForm", c);
		return new ModelAndView("/WEB-INF/cititori/edit.jsp", "model", model);
	}
	
	@RequestMapping(value="save.htm", method = RequestMethod.POST)
	public ModelAndView saveCititori(@ModelAttribute("cititoriForm") Cititori cititori, ModelMap model, BindingResult result) {
		model.put("mesaj", "");
		Cititori carteiObj;
		
		try {
			carteiObj = CititoriDAO.getCititoriById(cititori.getId());
			carteiObj.setNume(cititori.getNume());
			carteiObj.setPrenume(cititori.getPrenume());
			carteiObj.setAdresa(cititori.getAdresa());
			carteiObj.setLocalitate(cititori.getLocalitate());
			carteiObj.setJudet(cititori.getJudet());
			carteiObj.setTelefon(cititori.getTelefon());
			carteiObj.setEmail(cititori.getEmail());
			CititoriDAO.updateCititori(carteiObj);
			model.put("cititoriForm", cititori);
			model.put("mesaj", "Cartea a fost Salvata");
		} catch(NumberFormatException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("/WEB-INF/cititori/edit.jsp", "model", model);
	}
	
	@RequestMapping(value = "/delete.htm")
	public ModelAndView deleteCarte(@RequestParam Integer id, Model model) throws NumberFormatException, SQLException {
		
		CititoriDAO.deleteCarte(id);
		LinkedList<Cititori> cititori = CititoriDAO.getAllCititori();
		model.addAttribute("cititori", cititori);
		return new ModelAndView("/WEB-INF/cititori/lista.jsp", "model", model);
	}
	
	@RequestMapping(value = "/add.htm")
	public ModelAndView adaugaCarte(Model model) throws NumberFormatException, SQLException {
		Cititori cititori = new Cititori();
		model.addAttribute("cititoriForm", cititori);
		return new ModelAndView("/WEB-INF/cititori/add.jsp", "model", model);
	}
	
	@RequestMapping(value = "/add-save", method = RequestMethod.POST)
	public ModelAndView addCititori(@ModelAttribute("cititoriForm") Cititori cititori, ModelMap model, BindingResult result) {
		
		try {
			CititoriDAO.insert(cititori);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/cititori/lista.htm");
	}
	
}
