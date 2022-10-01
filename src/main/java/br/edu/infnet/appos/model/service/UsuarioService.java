package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.exceptions.UsuarioJaCadastradoException;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }


    public void cadastrar(Usuario usuario) throws UsuarioJaCadastradoException {
        if (usuarioRepository.existsByEmail(usuario.getEmail()))
            throw new UsuarioJaCadastradoException("E-mail " + usuario.getEmail() + " já cadastrado no sistema");

        usuarioRepository.save(usuario);
    }

    public Usuario findByEmail(String email) {

        return usuarioRepository.findByEmail(email).orElseThrow();
    }

    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
