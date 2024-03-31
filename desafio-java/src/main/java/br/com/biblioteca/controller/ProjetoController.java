package br.com.biblioteca.controller;

import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService service;

    @GetMapping("/listarProjetos")
    public String listarProjetos(Model model) {
        model.addAttribute("projetos", service.listarProjetos());
        return "/listarProjetos";
    }

    @GetMapping("/cadastrarProjeto")
    public String cadastrarProjeto(Model model) {
        model.addAttribute("novoProjeto", new Projeto());
        return "/cadastrarProjeto";
    }

    @PostMapping("/salvarProjeto")
    public String salvarProjeto(@Valid @ModelAttribute("novoProjeto") Projeto projeto) {
        service.salvar(projeto);
        return "/cadastrarProjeto";
    }

    @GetMapping("/{id}")
    public String listarProjetoById(@Valid @PathVariable Long id, Model model) throws Exception {
        Projeto projeto = service.getProjetoById(id);
        model.addAttribute("objetoProjeto", projeto);
        return "/editarProjeto";
    }

    @PostMapping("/{id}")
    public String alterarProjeto(@PathVariable("id") Long id, @ModelAttribute("objetoProjeto") @Valid Projeto projeto, BindingResult error) {

        if(error.hasErrors()){
            projeto.setId(id);
            return "/editarProjeto";
        }

        service.alterar(projeto);
        return "/listarProjetos";
    }
}
