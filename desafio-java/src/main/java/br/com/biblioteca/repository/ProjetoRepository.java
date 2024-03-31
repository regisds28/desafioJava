package br.com.biblioteca.repository;

import br.com.biblioteca.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {


}
