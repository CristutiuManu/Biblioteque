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

import com.dao.ImprumuturiDAO;
import com.pojo.Imprumuturi;

@RequestMapping("imprumuturi")
@Controller
public class ImprumuturiController {

	@RequestMapping(value="lista.htm")
	public ModelAndView afisareImprumuturi() throws SQLException {
		LinkedList<Imprumuturi> imprumuturi = ImprumuturiDAO.getAllImprumuturi();
		ModelMap model = new ModelMap();
		model.put("imprumuturi", imprumuturi);	
		return new ModelAndView("/WEB-INF/imprumuturi/lista.jsp", "model", model);		
	}
	
	@RequestMapping(value="detalii.htm")
	public ModelAndView afisareDetalii(@RequestParam Integer id) throws SQLException {
		Imprumuturi i = ImprumuturiDAO.getImprumuturiById(id);
		ModelMap model=new ModelMap();
		model.put("imprumuturi", i);
		return new ModelAndView("/WEB-INF/imprumuturi/detalii.jsp", "model", model);
	}
	
	@RequestMapping(value="edit.htm")
	public ModelAndView imprumuturiEdit(@RequestParam Integer id, Model model) throws SQLException {
		Imprumuturi i = ImprumuturiDAO.getImprumuturiById(id);
		model.addAttribute("imprumuturiForm", i);
		return new ModelAndView("/WEB-INF/imprumuturi/edit.jsp", "model", model);
	}
	
	@RequestMapping(value="save.htm", method = RequestMethod.POST)
	public ModelAndView saveImprumuturi(@ModelAttribute("imprumuturiForm") Imprumuturi imprumuturi, ModelMap model, BindingResult result) {
		model.put("mesaj", "");
		Imprumuturi imprumuturiObj;
		
		try {
			imprumuturiObj = ImprumuturiDAO.getImprumuturiById(imprumuturi.getId());
			imprumuturiObj.setId_cititor(imprumuturi.getId_cititor());
			imprumuturiObj.setId_carte(imprumuturi.getId_carte());
			imprumuturiObj.setData_imprumut(imprumuturi.getData_imprumut());
			imprumuturiObj.setData_returnare(imprumuturi.getData_returnare());
			ImprumuturiDAO.updateImprumuturi(imprumuturiObj);
			model.put("imprumuturiForm", imprumuturi);
			model.put("mesaj", "Imprumutul a fost Salvat");
		} catch(NumberFormatException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("/WEB-INF/imprumuturi/edit.jsp", "model", model);
	}
	
	@RequestMapping(value = "/delete.htm")
	public ModelAndView deleteImprumut(@RequestParam Integer id, Model model) throws NumberFormatException, SQLException {
		
		ImprumuturiDAO.deleteImprumut(id);
		LinkedList<Imprumuturi> imprumuturi = ImprumuturiDAO.getAllImprumuturi();
		model.addAttribute("imprumuturi", imprumuturi);
		return new ModelAndView("/WEB-INF/imprumuturi/lista.jsp", "model", model);
	}
	
	@RequestMapping(value = "/add.htm")
	public ModelAndView adaugaImprumut(Model model) throws NumberFormatException, SQLException {
		Imprumuturi imprumuturi = new Imprumuturi();
		model.addAttribute("imprumuturiForm", imprumuturi);
		return new ModelAndView("/WEB-INF/imprumuturi/add.jsp", "model", model);
	}
	
	@RequestMapping(value = "/add-save", method = RequestMethod.POST)
	public ModelAndView addImprumuturi(@ModelAttribute("imprumuturiForm") Imprumuturi imprumuturi, ModelMap model, BindingResult result) {
		
		try {
			ImprumuturiDAO.insert(imprumuturi);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/imprumuturi/lista.htm");
	}
	
	
}
