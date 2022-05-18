package com.projects.praticandoAPI.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.projects.praticandoAPI.controller.dto.LivroDto;
import com.projects.praticandoAPI.controller.form.LivroForm;
import com.projects.praticandoAPI.modelo.Livro;
import com.projects.praticandoAPI.modelo.TipoPlano;
import com.projects.praticandoAPI.modelo.Usuario;
import com.projects.praticandoAPI.repository.LivroRepository;
import com.projects.praticandoAPI.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/{usuarioId}")
    public List<LivroDto> listaPorUsuario(@PathVariable Long usuarioId) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(usuarioId);

        List<Livro> livros;
        if (usuario.get().getTipoPlano() == TipoPlano.Free)
            livros = this.livroRepository
                    .findByAnimacaoRealidadeAumentada(false);
        else
            livros = this.livroRepository.findAll();

        return LivroDto.converter(livros);
    }

    @PostMapping
    public ResponseEntity<LivroDto> cadastrar(@RequestBody LivroForm form, UriComponentsBuilder uriBuilder) {
        Livro livro = form.converter(livroRepository);
        this.livroRepository.save(livro);

        URI uri = uriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(new LivroDto(livro));
    }
}
