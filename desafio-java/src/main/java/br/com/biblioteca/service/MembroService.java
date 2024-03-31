package br.com.biblioteca.service;

import br.com.biblioteca.model.Membro;
import br.com.biblioteca.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembroService {

    @Autowired
    private MembroRepository repository;

    public Membro salvar(Membro membro) {
        return repository.save(membro);
    }

}
