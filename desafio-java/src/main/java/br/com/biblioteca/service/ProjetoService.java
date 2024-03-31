package br.com.biblioteca.service;

import br.com.biblioteca.ProjetoRepository;
import br.com.biblioteca.dto.ProjetoDTO;
import br.com.biblioteca.enums.RiscoEnum;
import br.com.biblioteca.enums.StatusEnum;
import br.com.biblioteca.enums.ValidationEnum;
import br.com.biblioteca.model.Projeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResource;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    public List<Projeto> listarProjetos() {
        List<Projeto> list = repository.findAll();
        return list;
    }

    public Projeto getProjetoById(Long projetoId) throws Exception {
        Optional<Projeto> optionalProjeto = getOptional(projetoId);
        Projeto projeto = null;
        if ((!optionalProjeto.isPresent())) {
            throw new Exception("Projeto do id "+projetoId+" não encontrado");
        }else{
            projeto = optionalProjeto.get();
        }
        return projeto;
    }

    private Optional<Projeto> getOptional(Long id){
        Optional<Projeto> optionalProjeto = repository.findById(id);
        return optionalProjeto;
    }

    public Projeto salvar(Projeto projeto) {
        projeto.setStatus(StatusEnum.EM_ANALISE);
        projeto.setRisco(RiscoEnum.ALTO);
        return repository.save(projeto);
    }

    public ResponseEntity<Object> deleteProjetoId(long clienteId) {

        repository.deleteById(clienteId);

        return ResponseEntity.ok().build();

    }

    public List<Projeto> filtraPor(Projeto filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Projeto> exemplo = Example.of(filtro, matcher);

        return repository.findAll(exemplo);
    }

    public Projeto getProjeto(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
    }

    public Projeto alterar(Projeto projeto) {
        return salvar(projeto);
    }

}
