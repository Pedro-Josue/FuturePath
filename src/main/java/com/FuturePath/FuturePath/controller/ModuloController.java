package com.FuturePath.FuturePath.controller;

import com.FuturePath.FuturePath.model.Modulo;
import com.FuturePath.FuturePath.service.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modulos")
public class ModuloController {
    @Autowired
    private ModuloService moduloService;

    @GetMapping
    public List<Modulo> listaModulos() {
        return moduloService.listaModulos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable Long id) {
        return moduloService.buscaPorId(id);
    }

    @PostMapping("/novo")
    public ResponseEntity<String> criaModulo(@RequestBody Modulo modulo) {
        return moduloService.criaModulo(modulo);
    }

    @PutMapping("/edita/{id}")
    public ResponseEntity<String> editaModulo(@PathVariable Long id, @RequestBody Modulo modulo) {
        return moduloService.editaModulo(id, modulo);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluiModulo(@PathVariable Long id) {
        return moduloService.excluiModulo(id);
    }
}
