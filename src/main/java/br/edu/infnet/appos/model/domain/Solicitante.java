package br.edu.infnet.appos.model.domain;

import br.edu.infnet.appos.exceptions.NomeNaoPreenchidoException;
import br.edu.infnet.appos.interfaces.IPrinter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data @AllArgsConstructor
public class Solicitante implements IPrinter {
    private String nome;
    private String telefone;
    private boolean vip;

    private Integer id = 0;

    public Solicitante(String nome, String telefone, boolean vip) throws NomeNaoPreenchidoException {
        if (Objects.isNull(nome))
            throw new NomeNaoPreenchidoException("O nome do solicitante não pode ser nulo");

        if (nome == "")
            throw new NomeNaoPreenchidoException("O nome do solicitante não pode ser em branco");

        this.nome = nome;
        this.telefone = telefone;
        this.vip = vip;
    }

    @Override public void impressao() {
        System.out.println("### Solicitante ###");
        System.out.println(toString());
    }

    @Override
    public String toString() {

        return "Solicitante: [" + nome + ";" + telefone + ";" + vip + "]";
    }
}
