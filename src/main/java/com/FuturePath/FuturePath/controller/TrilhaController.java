package com.FuturePath.FuturePath.controller;

import com.FuturePath.FuturePath.model.Trilha;
import com.FuturePath.FuturePath.service.TrilhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trilhas")
public class TrilhaController {
    @Autowired
    private TrilhaService trilhaService;

    @GetMapping
    public List<Trilha> listaTrilhas(){
        return trilhaService.listaTrilhas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable Long id) {
        return trilhaService.buscaPorId(id);
    }

    @PostMapping("/novo")
    public ResponseEntity<String> criaTrilha(@RequestBody Trilha trilha){
        return trilhaService.criaTrilha(trilha);
    }

    @PutMapping("/edita/{id}")
    public ResponseEntity<String> editaTrilha(@PathVariable Long id, @RequestBody Trilha trilha){
        return trilhaService.editaTrilha(id, trilha);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluiTrilha(@PathVariable Long id){
        return trilhaService.excluiTrilha(id);
    }
}
