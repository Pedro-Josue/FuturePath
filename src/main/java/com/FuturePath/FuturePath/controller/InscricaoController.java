package com.FuturePath.FuturePath.controller;

import com.FuturePath.FuturePath.model.Inscricao;
import com.FuturePath.FuturePath.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {
    @Autowired
    private InscricaoService inscricaoService;

    @GetMapping
    public List<Inscricao> listaInscricoes() {
        return inscricaoService.listaInscricoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable Long id) {
        return inscricaoService.buscaPorId(id);
    }

    @PostMapping("/nova")
    public ResponseEntity<String> criaInscricao(@RequestBody Inscricao inscricao) {
        return inscricaoService.criaInscricao(inscricao);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluiInscricao(@PathVariable Long id) {
        return inscricaoService.excluiInscricao(id);
    }
}
