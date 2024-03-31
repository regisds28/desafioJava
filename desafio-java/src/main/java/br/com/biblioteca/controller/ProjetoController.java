package br.com.biblioteca.controller;

import br.com.biblioteca.dto.ProjetoDTO;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.service.ProjetoService;
import org.springframework.beans.BeanUtils;
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
    public String salvarProjeto(@Valid @ModelAttribute("novoProjeto") ProjetoDTO projetoDto) {
        Projeto projeto = new Projeto();
        BeanUtils.copyProperties(projetoDto, projeto);
        service.salvar(projeto);
        return "/listarProjetos";
    }

    @GetMapping("/{id}")
    public String editarProjeto(@PathVariable("id") Long id, Model model) {

        try {
            Projeto projeto = service.buscarProjetoPorId(id);
            model.addAttribute("objetoProjeto", projeto);
            return "/editarProjeto";
        } catch (Exception e) {
            e.getMessage();
        }
        return "/listarProjetos";
    }

    @PostMapping("/{id}")
    public String alterarProjeto(@PathVariable("id") Long id, @ModelAttribute("objetoProjeto") @Valid ProjetoDTO projetoDto, BindingResult error) {

        Projeto projeto = new Projeto();

        if(error.hasErrors()){
            projeto.setId(id);
            return "/editarProjeto";
        }

        BeanUtils.copyProperties(projetoDto, projeto);
        service.alterar(projeto);
        return "/listarProjetos";
    }

    @GetMapping("/apagar/{id}")
    public String apagarProjeto(@PathVariable("id") long id) {
        try {
            service.deleteProjetoId(id);
        } catch (Exception e) {
            e.getMessage();
        }
        return "/listarProjetos";
    }

}
