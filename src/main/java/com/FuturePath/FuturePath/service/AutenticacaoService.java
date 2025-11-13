package com.FuturePath.FuturePath.service;

import com.FuturePath.FuturePath.exception.UsuarioNaoEncontradoException;
import com.FuturePath.FuturePath.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuarioExistente = usuarioRepository.findByLogin(username);
        if (usuarioExistente == null) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado: ");
        }
        return usuarioExistente;
    }
}
