package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.exceptions.UsuarioJaCadastradoException;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    public List<Usuario> findAll() {
        return repository.findAll();
    }


    public void cadastrar(HttpServletRequest request) throws UsuarioJaCadastradoException {
        Usuario usuario = new Usuario();
        usuario.setEmail(request.getParameter("email"));
        usuario.setNome(request.getParameter("nome"));
        usuario.setPassword(request.getParameter("password"));
        if (repository.existsById(usuario.getEmail()))
            throw new UsuarioJaCadastradoException("E-mail " + usuario.getEmail() + " já cadastrado no sistema");

        repository.save(usuario);
    }
}
