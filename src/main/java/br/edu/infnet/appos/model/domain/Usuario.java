package br.edu.infnet.appos.model.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @RequiredArgsConstructor @NoArgsConstructor @ToString
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

    @OneToMany
    @JoinColumn(name = "idUsuario") @ToString.Exclude private List<Veiculo> veiculos;

    @OneToMany
    @JoinColumn(name = "idUsuario") @ToString.Exclude private List<Solicitante> solicitantes;

    @OneToMany
    @JoinColumn(name = "idUsuario") @ToString.Exclude private List<Servico> servicos;

    @OneToMany
    @JoinColumn(name = "idUsuario") @ToString.Exclude private List<OrdemServico> ordensServicos;
}
