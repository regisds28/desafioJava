package br.com.biblioteca.controller;

import br.com.biblioteca.dto.ProjetoDTO;
import br.com.biblioteca.enums.RiscoEnum;
import br.com.biblioteca.enums.StatusEnum;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {

    public static final String LISTA_MEMBROS = "listaMembros";
    public static final String FWD_LISTA = "redirect:/projetos/listarProjetos";

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
        model.addAttribute(LISTA_MEMBROS, list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/cadastrarProjeto")
    public String cadastrarProjeto(Model model) {
        model.addAttribute("novoProjeto", new Projeto());
        model.addAttribute(LISTA_MEMBROS, service.listarMembros());
        model.addAttribute("listarStatus", StatusEnum.values());
        model.addAttribute("listarRiscos", RiscoEnum.values());
        return "/cadastrarProjeto";
    }

    @PostMapping("/salvarProjeto")
    public String salvarProjeto(@Valid @ModelAttribute("novoProjeto") ProjetoDTO projetoDto, RedirectAttributes attributes) {
        Projeto projeto = new Projeto();

        try{
            BeanUtils.copyProperties(projetoDto, projeto);
            service.salvar(projeto);
            attributes.addFlashAttribute("cadastrarProjeto", true);
        }catch (Exception e) {
            e.getMessage();
            attributes.addFlashAttribute("cadastrarProjeto", false);
        }

        return FWD_LISTA;
    }

    @GetMapping("/editar/{id}")
    public String editarProjeto(@PathVariable("id") Long id, Model model) {

        try {
            Projeto projeto = service.buscarProjetoPorId(id);
            model.addAttribute("objetoProjeto", projeto);
            model.addAttribute(LISTA_MEMBROS, service.listarMembros());
            return "/editarProjeto";
        } catch (Exception e) {
            e.getMessage();
        }
        return FWD_LISTA;
    }

    @PostMapping("/editar/{id}")
    public String alterarProjeto(@PathVariable("id") Long id, @ModelAttribute("objetoProjeto") @Valid ProjetoDTO projetoDto, BindingResult error, RedirectAttributes attributes) throws Exception {

        Projeto projeto = service.getProjetoById(id);

        if(error.hasErrors()){
            projeto.setId(id);
            return "/editarProjeto";
        }

        BeanUtils.copyProperties(projetoDto, projeto);
        service.alterar(projeto);
        attributes.addFlashAttribute("editarProjeto", true);
        return FWD_LISTA;
    }

    @GetMapping("/apagar/{id}")
    public String apagarProjeto(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            service.deleteProjetoId(id);
            attributes.addFlashAttribute("excluirProjeto", true);
        } catch (Exception e) {
            e.getMessage();
        }
        return FWD_LISTA;
    }

}
