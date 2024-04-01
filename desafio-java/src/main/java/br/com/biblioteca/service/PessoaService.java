package br.com.biblioteca.service;

import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

}
