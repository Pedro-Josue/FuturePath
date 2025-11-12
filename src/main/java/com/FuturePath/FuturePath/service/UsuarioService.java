package com.FuturePath.FuturePath.service;

import com.FuturePath.FuturePath.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository UsuarioRepository;
}
