package com.FuturePath.FuturePath.service;

import com.FuturePath.FuturePath.model.Modulo;
import com.FuturePath.FuturePath.model.Trilha;
import com.FuturePath.FuturePath.repository.ModuloRepository;
import com.FuturePath.FuturePath.repository.TrilhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuloService {
    @Autowired
    private ModuloRepository moduloRepository;
    @Autowired
    private TrilhaRepository trilhaRepository;

    public List<Modulo> listaModulos() {
        return moduloRepository.findAll();
    }

    public ResponseEntity<?> buscaPorId(Long id) {
        return moduloRepository.findById(id)
                .<ResponseEntity<?>>map(modulo -> ResponseEntity.ok(modulo))
                .orElse(ResponseEntity.status(404).body("Módulo não encontrado"));
    }

    public ResponseEntity<String> criaModulo(Modulo modulo) {

        if (modulo.getTrilha() == null || modulo.getTrilha().getId() == null) {
            return ResponseEntity.status(400).body("É necessário informar uma trilha válida.");
        }

        Optional<Trilha> trilhaOptional = trilhaRepository.findById(modulo.getTrilha().getId());
        if (trilhaOptional.isEmpty()) {
            return ResponseEntity.status(404).body("Trilha informada não existe.");
        }

        modulo.setTrilha(trilhaOptional.get());
        moduloRepository.save(modulo);
        return ResponseEntity.status(201).body("Módulo criado com sucesso!");
    }

    public ResponseEntity<String> editaModulo(Long id, Modulo modulo) {
        Optional<Modulo> existenteOptional = moduloRepository.findById(id);

        if (existenteOptional.isPresent()) {
            Modulo existente = existenteOptional.get();
            existente.setTitulo(modulo.getTitulo());
            existente.setDescricao(modulo.getDescricao());
            existente.setTipo(modulo.getTipo());
            existente.setCapitulo(modulo.getCapitulo());

            moduloRepository.save(existente);
            return ResponseEntity.status(200).body("Módulo atualizado com sucesso!");
        }

        return ResponseEntity.status(404).body("Módulo não encontrado.");
    }

    public ResponseEntity<String> excluiModulo(Long id) {
        Optional<Modulo> existenteOptional = moduloRepository.findById(id);

        if (existenteOptional.isPresent()) {
            try {
                moduloRepository.delete(existenteOptional.get());
                return ResponseEntity.status(200).body("Módulo excluído com sucesso!");
            } catch (DataIntegrityViolationException e) {
                return ResponseEntity.status(409).body("Não é possível excluir o módulo pois há relações vinculadas.");
            }
        }

        return ResponseEntity.status(404).body("Módulo não encontrado.");
    }
}
