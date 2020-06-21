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

import com.dao.AutoriDAO;
import com.pojo.Autori;

@RequestMapping("autori")
@Controller
public class AutoriController {

	@RequestMapping(value="lista.htm")
	public ModelAndView afisareAutori() throws SQLException {
		LinkedList<Autori> autori = AutoriDAO.getAllAutori();
		ModelMap model = new ModelMap();
		model.put("autori", autori);	
		return new ModelAndView("/WEB-INF/autori/lista.jsp", "model", model);		
	}
	
	@RequestMapping(value="detalii.htm")
	public ModelAndView afisareDetalii(@RequestParam Integer id) throws SQLException {
		Autori a = AutoriDAO.getAutoriById(id);
		ModelMap model=new ModelMap();
		model.put("autori", a);
		return new ModelAndView("/WEB-INF/autori/detalii.jsp", "model", model);
	}
	
	@RequestMapping(value="edit.htm")
	public ModelAndView autoriEdit(@RequestParam Integer id, Model model) throws SQLException {
		Autori a = AutoriDAO.getAutoriById(id);
		model.addAttribute("autoriForm", a);
		return new ModelAndView("/WEB-INF/autori/edit.jsp", "model", model);
	}
	
	@RequestMapping(value="save.htm", method = RequestMethod.POST)
	public ModelAndView saveAutori(@ModelAttribute("autoriForm") Autori autori, ModelMap model, BindingResult result) {
		model.put("mesaj", "");
		Autori autoriObj;
		
		try {
			autoriObj = AutoriDAO.getAutoriById(autori.getId());
			autoriObj.setNume(autori.getNume());
			autoriObj.setPrenume(autori.getPrenume());
			autoriObj.setData_nasterii(autori.getData_nasterii());
			autoriObj.setData_decesului(autori.getData_decesului());
			AutoriDAO.updateAutori(autoriObj);
			model.put("autoriForm", autori);
			model.put("mesaj", "Autorul a fost Salvat");
		} catch(NumberFormatException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("/WEB-INF/autori/edit.jsp", "model", model);
	}
	
	@RequestMapping(value = "/delete.htm")
	public ModelAndView deleteAutor(@RequestParam Integer id, Model model) throws NumberFormatException, SQLException {
		
		AutoriDAO.deleteAutor(id);
		LinkedList<Autori> autori = AutoriDAO.getAllAutori();
		model.addAttribute("autori", autori);
		return new ModelAndView("/WEB-INF/autori/lista.jsp", "model", model);
	}
	
	@RequestMapping(value = "/add.htm")
	public ModelAndView adaugaAutor(Model model) throws NumberFormatException, SQLException {
		Autori autori = new Autori();
		model.addAttribute("autoriForm", autori);
		return new ModelAndView("/WEB-INF/autori/add.jsp", "model", model);
	}
	
	@RequestMapping(value = "/add-save", method = RequestMethod.POST)
	public ModelAndView addAutori(@ModelAttribute("autoriForm") Autori autori, ModelMap model, BindingResult result) {
		
		try {
			AutoriDAO.insert(autori);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/autori/lista.htm");
	}
	
	
}
