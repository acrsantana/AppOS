package br.edu.infnet.appos.model.domain;

import br.edu.infnet.appos.interfaces.IPrinter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Entity @Table(name = "veiculos")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veiculo implements IPrinter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String marca;
    private String modelo;
    private int anoFabricacao;

    @OneToOne
    private Usuario usuario;

    public abstract int getPotencia();


    @Override
    public String toString() {
        return marca + ";" + modelo + ";" + anoFabricacao;
    }
}

