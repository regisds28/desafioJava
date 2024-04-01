package br.com.biblioteca.controller;

import br.com.biblioteca.dto.ProjetoDTO;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.service.ProjetoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping(value = "/membros", produces = "application/json")
    public ResponseEntity<List<Pessoa>> listaMembros(Model model){
        List<Pessoa> list = service.listarMembros();
        model.addAttribute("listaMembros", list);
        return new ResponseEntity<List<Pessoa>>(list, HttpStatus.OK);
    }

    @GetMapping("/cadastrarProjeto")
    public String cadastrarProjeto(Model model) {
        model.addAttribute("novoProjeto", new Projeto());
        model.addAttribute("listaMembros", service.listarMembros());
        return "/cadastrarProjeto";
    }

    @PostMapping("/salvarProjeto")
    public String salvarProjeto(@Valid @ModelAttribute("novoProjeto") ProjetoDTO projetoDto) {
        Projeto projeto = new Projeto();
        BeanUtils.copyProperties(projetoDto, projeto);
        service.salvar(projeto);
        return "/listarProjetos";
    }

    @GetMapping("/editar/{id}")
    public String editarProjeto(@PathVariable("id") Long id, Model model) {

        try {
            Projeto projeto = service.buscarProjetoPorId(id);
            model.addAttribute("objetoProjeto", projeto);
            model.addAttribute("listaMembros", service.listarMembros());
            return "/editarProjeto";
        } catch (Exception e) {
            e.getMessage();
        }
        return "/listarProjetos";
    }

    @PostMapping("/editar/{id}")
    public String alterarProjeto(@PathVariable("id") Long id, @ModelAttribute("objetoProjeto") @Valid ProjetoDTO projetoDto, BindingResult error) throws Exception {

        Projeto projeto = service.getProjetoById(id);

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
