package br.com.biblioteca.service.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.biblioteca.repository.ProjetoRepository;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.service.ProjetoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

@SpringBootTest
@WebAppConfiguration
@Sql(scripts = "/sql/insert_projeto_buscar_id_test.sql")
public class ProjetoServiceTest {
    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private ProjetoRepository repository;

    @Test
    public void getProjetoByIdTest() throws Exception {
        Projeto projeto = projetoService.getProjetoById(14L);

        assertEquals("Primeiro projeto", projeto.getNome());
        assertEquals(254871,254871, String.valueOf(projeto.getOrcamento()));
        assertEquals("Projeto desafio Java", projeto.getDescricao());
        assertEquals("novo gerente", projeto.getGerente());
        assertEquals("2024-03-30", String.valueOf(projeto.getDataFim()));
        assertEquals("2024-03-01", String.valueOf(projeto.getDataInicio()));
        assertEquals("2024-03-30", String.valueOf(projeto.getDataPrevisaoFim()));
        assertEquals(2, 2, String.valueOf(projeto.getRisco()));
        assertEquals(2, 2, String.valueOf(projeto.getStatus()));
    }

    @Test
    public void deleteProjetoIdTest() throws Exception{
        projetoService.deleteProjetoId(14L);

        Optional<Projeto> optionalProjeto = repository.findById(14L);

        assertFalse(optionalProjeto.isPresent());
    }
}