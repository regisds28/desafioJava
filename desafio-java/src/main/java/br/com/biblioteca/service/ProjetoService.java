package br.com.biblioteca.service;

import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.repository.PessoaRepository;
import br.com.biblioteca.repository.ProjetoRepository;
import br.com.biblioteca.enums.RiscoEnum;
import br.com.biblioteca.enums.StatusEnum;
import br.com.biblioteca.model.Projeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    @Autowired
    private PessoaRepository membroRepository;

    public List<Projeto> listarProjetos() {
        List<Projeto> list = repository.findAll();
        return list;
    }

    public List<Pessoa> listarMembros() {
        List<Pessoa> list = membroRepository.findAll();
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
        projeto.setStatus(StatusEnum.ANALISE_APROVADA);
        projeto.setRisco(RiscoEnum.ALTO);
        return repository.save(projeto);
    }

    public Projeto buscarProjetoPorId(Long id) throws Exception {
        Optional<Projeto> opt = repository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new Exception("Projeto com id : " + id + " não existe");
        }
    }


    public void deleteProjetoId(Long id) throws Exception {
        Projeto projeto = buscarProjetoPorId(id);
        repository.delete(projeto);
    }

    public Projeto alterar(Projeto projeto) {
        return salvar(projeto);
    }

}
