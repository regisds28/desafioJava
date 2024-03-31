package br.com.biblioteca.controller;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="tb_membro")
public class Membro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeMembro;
    private String cargo;
}
