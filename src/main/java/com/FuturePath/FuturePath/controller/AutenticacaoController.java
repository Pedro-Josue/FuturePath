package com.FuturePath.FuturePath.controller;

import com.FuturePath.FuturePath.model.Usuario;
import com.FuturePath.FuturePath.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    //utilizando authentication manager do spring para autenticar o usuario
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> logar(@RequestBody Map<String, String> body){
        String login = body.get("login");
        String senha = body.get("senha");

        try {
            var token = new UsernamePasswordAuthenticationToken(login, senha);
            var authentication = authenticationManager.authenticate(token);

            String JWT = tokenService.geraToken((Usuario) authentication.getPrincipal());
            Map<String, String> resposta = new HashMap<>();
            resposta.put("token", JWT);
            return ResponseEntity.ok(resposta);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }

    }
}
