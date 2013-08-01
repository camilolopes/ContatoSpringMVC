package com.camilolopes.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camilolopes.springmvc.dao.ContatoDAO;
import com.camilolopes.springmvc.domain.Contato;

@Controller
@RequestMapping("/contato/**")
public class ContatoController {
	@Autowired
	private ContatoDAO contatoDAO;
	
	@RequestMapping(value="/contato/form", method=RequestMethod.GET)
	public String form(ModelMap modelMap){
		//cria um contato e attribute para ele 
		modelMap.addAttribute("contato", new Contato());
		//chama o arquivo create.jsp quando receber  o request /app/contato/form
		return "contato/create";
	}
	
	@RequestMapping(value="/contato", method=RequestMethod.POST)
	public String create(@ModelAttribute("contato")Contato contato){
		contatoDAO.save(contato);
		//quando chegar um post do atributo contato vai perssit o objeto e redirecionr para pagina incial
		return "redirect:/contato/list";
	}
	
	@RequestMapping(value="/contato/list",method=RequestMethod.GET)
	public String list(ModelMap modelMap){
		final List<Contato> listAllContatos = contatoDAO.readAll();
		modelMap.addAttribute("contatos",listAllContatos);
		return "contato/list";
	}

	public ContatoDAO getContatoDAO() {
		return contatoDAO;
	}

	public void setContatoDAO(ContatoDAO contatoDAO) {
		this.contatoDAO = contatoDAO;
	}

}
