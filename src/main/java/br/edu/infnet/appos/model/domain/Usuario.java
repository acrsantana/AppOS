package br.edu.infnet.appos.model.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    private String email;
    private String nome;
    private String password;
}
