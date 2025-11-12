package com.FuturePath.FuturePath.service;

import com.FuturePath.FuturePath.model.Trilha;
import com.FuturePath.FuturePath.repository.TrilhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrilhaService {
    @Autowired
    private TrilhaRepository trilhaRepository;

    public List<Trilha> listaTrilhas() {
        return trilhaRepository.findAll();
    }

    public ResponseEntity<String> criaTrilha(Trilha trilha) {
        trilhaRepository.save(trilha);
        return ResponseEntity.status(201).body("Trilha criada com sucesso!");
    }

    public ResponseEntity<String> editaTrilha(Long id, Trilha trilha) {
        return trilhaRepository.findById(id).map(existente -> {
            existente.setTitulo(trilha.getTitulo());
            existente.setDescricao(trilha.getDescricao());
            existente.setArea(trilha.getArea());
            existente.setCargaHoraria(trilha.getCargaHoraria());
            trilhaRepository.save(existente);
            return ResponseEntity.status(200).body("Trilha atualizada com sucesso!");
        }).orElse(ResponseEntity.status(404).body("Trilha não encontrada."));
    }

    public ResponseEntity<String> excluiTrilha(Long id) {
        return trilhaRepository.findById(id).map(existente -> {
            try {
                trilhaRepository.delete(existente);
                return ResponseEntity.status(200).body("Trilha excluída com sucesso!");
            } catch (DataIntegrityViolationException e) {
                return ResponseEntity.status(409).body("Não é possível excluir a trilha pois ela possui módulos vinculados.");
            }
        }).orElse(ResponseEntity.status(404).body("Trilha não encontrada."));
    }

    public ResponseEntity<?> buscaPorId(Long id) {
        return trilhaRepository.findById(id)
                .<ResponseEntity<?>>map(trilha -> ResponseEntity.ok(trilha))
                .orElse(ResponseEntity.status(404).body("Trilha não encontrada"));
    }
}
