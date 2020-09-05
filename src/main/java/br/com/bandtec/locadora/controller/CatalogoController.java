package br.com.bandtec.locadora.controller;

import br.com.bandtec.locadora.Alugavel;
import br.com.bandtec.locadora.ControleCatalogo;
import br.com.bandtec.locadora.entidades.Filme;
import br.com.bandtec.locadora.entidades.Jogo;
import br.com.bandtec.locadora.entidades.Serie;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {

  public static ControleCatalogo controle = new ControleCatalogo();

  public CatalogoController() {
    if (controle.listarCatalogo().isEmpty()) {
      this.popularLista();
    }
  }

  @GetMapping
  public ResponseEntity listarAlugaveis() {
    List<Alugavel> catalogo = controle.listarCatalogo();

    if (catalogo.isEmpty()) {
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok(catalogo);
  }

  @GetMapping("/{filtro}")
  public ResponseEntity filtrarAlugaveis(@PathVariable String filtro) {
    List<Alugavel> catalogoFiltrado = controle.filtrarCatalogo(filtro);

    if (catalogoFiltrado.isEmpty()) {
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok(catalogoFiltrado);
  }

  @PostMapping("/filmes")
  public ResponseEntity cadastrarFilme(@RequestBody Filme filme) {
    controle.adicionaCatalogo(filme);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PostMapping("/series")
  public ResponseEntity cadastrarSerie(@RequestBody Serie serie) {
    controle.adicionaCatalogo(serie);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PostMapping("/jogos")
  public ResponseEntity cadastrarJogos(@RequestBody Jogo jogo) {
    controle.adicionaCatalogo(jogo);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity removeFilmes(@PathVariable Integer id) {
    if (controle.listarCatalogo().size() < id) {
      return ResponseEntity.notFound().build();
    }

    controle.removeCatalogo(id - 1);
    return ResponseEntity.ok().build();
  }

  public void popularLista() {
    controle.adicionaCatalogo(new Filme(
        "Toy Story 4",
        2019,
        "Animação",
        "Josh Cooley",
        7.8,
        100
    ));
    controle.adicionaCatalogo(new Filme(
        "A Origem",
        2010,
        "Ação",
        "Christopher Nolan",
        8.8,
        148
    ));
    controle.adicionaCatalogo(new Filme(
        "Matrix",
        1999,
        "Ação",
        "Lana Wachowski, Lilly Wachowski",
        8.7,
        136
    ));
    controle.adicionaCatalogo(new Serie(
        "Stranger Things",
        2016,
        "Drama, fantasia",
        "Matt e Ross Duffer",
        8.8,
        51,
        25
    ));
    controle.adicionaCatalogo(new Serie(
        "Game of Thrones",
        2011,
        "Ação",
        "David Benioff e D. B. Weiss",
        9.3,
        57,
        73
    ));
    controle.adicionaCatalogo(new Serie(
        "Fullmetal Alchemist Brotherhood",
        2009,
        "Ação",
        "Hiromu Arakawa",
        9.1,
        24,
        64
    ));
    controle.adicionaCatalogo(new Jogo(
        "Super Mario World",
        "Super Nintendo",
        1990,
        "Plataforma",
        8.5
    ));
    controle.adicionaCatalogo(new Jogo(
        "Star Fox 64",
        "Nintendo 64",
        1997,
        "Ação",
        8.7
    ));
    controle.adicionaCatalogo(new Jogo(
        "Sonic the Hedgehog 2",
        "Mega Drive",
        1992,
        "Plataforma",
        7.9
    ));
  }
}
