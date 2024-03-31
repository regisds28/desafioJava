package br.com.biblioteca.controller;

import br.com.biblioteca.dto.MembroDTO;
import br.com.biblioteca.model.Membro;
import br.com.biblioteca.service.MembroService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/membro")
public class MembroController {

    @Autowired
    private MembroService service;

    @PostMapping("/cadastrarMembro")
    public ResponseEntity<Membro> cadastrarMembro(@RequestBody @Valid MembroDTO membroDTO) {
        Membro membro = new Membro();
        BeanUtils.copyProperties(membro, membroDTO);
        service.salvar(membro);
        return new ResponseEntity<>(membro, HttpStatus.CREATED);
    }

}
