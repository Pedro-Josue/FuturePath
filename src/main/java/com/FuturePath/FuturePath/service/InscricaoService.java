package com.FuturePath.FuturePath.service;

import com.FuturePath.FuturePath.model.Inscricao;
import com.FuturePath.FuturePath.model.Trilha;
import com.FuturePath.FuturePath.model.Usuario;
import com.FuturePath.FuturePath.repository.InscricaoRepository;
import com.FuturePath.FuturePath.repository.TrilhaRepository;
import com.FuturePath.FuturePath.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InscricaoService {
    @Autowired
    private InscricaoRepository inscricaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TrilhaRepository trilhaRepository;

    public List<Inscricao> listaInscricoes() {
        return inscricaoRepository.findAll();
    }

    public ResponseEntity<?> buscaPorId(Long id) {
        return inscricaoRepository.findById(id)
                .<ResponseEntity<?>>map(inscricao -> ResponseEntity.ok(inscricao))
                .orElse(ResponseEntity.status(404).body("Inscrição não encontrada"));
    }

    public ResponseEntity<String> criaInscricao(Inscricao inscricao) {

        if (inscricao.getUsuario() == null || inscricao.getUsuario().getId() == null ||
                inscricao.getTrilha() == null || inscricao.getTrilha().getId() == null) {
            return ResponseEntity.status(400).body("Usuário e Trilha devem ser informados.");
        }

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(inscricao.getUsuario().getId());
        Optional<Trilha> trilhaOptional = trilhaRepository.findById(inscricao.getTrilha().getId());

        if (usuarioOptional.isEmpty()) return ResponseEntity.status(404).body("Usuário não encontrado.");
        if (trilhaOptional.isEmpty()) return ResponseEntity.status(404).body("Trilha não encontrada.");

        inscricao.setUsuario(usuarioOptional.get());
        inscricao.setTrilha(trilhaOptional.get());
        inscricao.setDataInscricao(LocalDate.now());

        inscricaoRepository.save(inscricao);
        return ResponseEntity.status(201).body("Inscrição realizada com sucesso!");
    }

    public ResponseEntity<String> excluiInscricao(Long id) {
        Optional<Inscricao> existente = inscricaoRepository.findById(id);

        if (existente.isPresent()) {
            inscricaoRepository.delete(existente.get());
            return ResponseEntity.status(200).body("Inscrição excluída com sucesso!");
        }

        return ResponseEntity.status(404).body("Inscrição não encontrada.");
    }
}
