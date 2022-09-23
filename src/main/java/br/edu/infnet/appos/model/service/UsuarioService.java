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
    private UsuarioRepository usuarioRepository;
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }


    public void cadastrar(HttpServletRequest request) throws UsuarioJaCadastradoException {
        Usuario usuario = new Usuario();
        usuario.setEmail(request.getParameter("email"));
        usuario.setNome(request.getParameter("nome"));
        usuario.setPassword(request.getParameter("password"));
        if (usuarioRepository.existsById(usuario.getEmail()))
            throw new UsuarioJaCadastradoException("E-mail " + usuario.getEmail() + " já cadastrado no sistema");

        usuarioRepository.save(usuario);
    }

    public void cadastrar(Usuario usuario) throws UsuarioJaCadastradoException {
        if (usuarioRepository.existsByEmail(usuario.getEmail()))
            throw new UsuarioJaCadastradoException("E-mail " + usuario.getEmail() + " já cadastrado no sistema");

        usuarioRepository.save(usuario);
    }

    public Usuario findById(String email) {

        return usuarioRepository.findById(email).orElseThrow();
    }

    public void delete(String email) {
        usuarioRepository.deleteById(email);
    }
}
