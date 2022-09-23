package br.edu.infnet.appos.model.domain;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @RequiredArgsConstructor @NoArgsConstructor
@Entity @Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String email;
    @NonNull
    private String nome;
    @NonNull
    private String password;
}
