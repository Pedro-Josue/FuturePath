package com.FuturePath.FuturePath.controller;

import com.FuturePath.FuturePath.repository.UsuarioRepository;
import com.FuturePath.FuturePath.security.TokenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AutenticacaoController.class)
public class AutenticacaoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private AuthenticationManager authenticationManager;

    private TokenService tokenService;

    private UsuarioRepository usuarioRepository;

    @Test
    void login_usuarioNaoEncontrado_retorna404() throws Exception {
        when(usuarioRepository.findByLogin("eunaoexisto")).thenReturn(null);

        String json = "{\"login\":\"eunaoexisto\",\"senha\":\"3431341\"}";

        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.erro").isNotEmpty());
    }

    @Test
    void login_senhaIncorreta_retorna401() throws Exception {
        // simula usuário existente
        when(usuarioRepository.findByLogin("existe")).thenReturn(org.mockito.Mockito.mock(com.FuturePath.FuturePath.model.Usuario.class));
        // authenticationManager lança exceção ao autenticar
        when(authenticationManager.authenticate(any())).thenThrow(new BadCredentialsException("Bad credentials"));

        String json = "{\"login\":\"existe\",\"senha\":\"senhaErrada\"}";

        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.status").value(401))
                .andExpect(jsonPath("$.erro").isNotEmpty());
    }
}
