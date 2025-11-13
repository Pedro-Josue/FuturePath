package com.FuturePath.FuturePath.service;

import com.FuturePath.FuturePath.exception.CredenciaisInvalidasException;
import com.FuturePath.FuturePath.model.Usuario;
import com.FuturePath.FuturePath.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String> criaUsuario(Usuario usuario) {
        if (usuarioRepository.findByLogin(usuario.getLogin()) != null) {
            return ResponseEntity.status(400).body("Login já cadastrado no sistema");
        }

        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        usuarioRepository.save(usuario);
        return ResponseEntity.status(201).body("Usuario criado com sucesso!");
    }
}
