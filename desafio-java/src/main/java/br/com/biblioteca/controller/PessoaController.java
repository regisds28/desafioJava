package br.com.biblioteca.controller;

import br.com.biblioteca.dto.PessoaDTO;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/membro")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping(path="/cadastrarMembro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> cadastrarMembro(@RequestBody @Valid PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        pessoa = service.salvar(pessoa);
        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }

}
