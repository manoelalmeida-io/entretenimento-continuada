package br.com.bandtec.locadora.controller;

import br.com.bandtec.locadora.Alugavel;
import br.com.bandtec.locadora.ControleAluguel;
import br.com.bandtec.locadora.entidades.Aluguel;
import br.com.bandtec.locadora.entidades.Filme;
import br.com.bandtec.locadora.entidades.Jogo;
import br.com.bandtec.locadora.entidades.Serie;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alugaveis")
public class AlugavelController {

  ControleAluguel controle = new ControleAluguel();

  /* LISTAR */
  @GetMapping
  public List<Alugavel> listarAlugaveis() {
    if (controle.listarAlugaveis().isEmpty()) {
      this.popularLista();
    }

    return controle.listarAlugaveis();
  }

  @GetMapping("/filtrar/{filtro}")
  public List<Alugavel> filtrarAlugaveis(@PathVariable String filtro) {
    if (controle.filtrarAlugaveis(filtro).isEmpty()) {
      this.popularLista();
    }

    return controle.filtrarAlugaveis(filtro);
  }

  @GetMapping("/alugueis")
  public List<Aluguel> listarAlugueis() {
    return controle.listarAlugueis();
  }

  @GetMapping("/alugueis/filtrar/{filtro}")
  public List<Aluguel> filtrarAlugueis(@PathVariable String filtro) {
    return controle.filtrarAlugueis(filtro);
  }

  /* CADASTRAR */
  @PostMapping("/filmes")
  public void cadastrarFilme(@RequestBody Filme filme) {
    controle.adicionaAlugavel(filme);
  }

  @PostMapping("/series")
  public void cadastrarSerie(@RequestBody Serie serie) {
    controle.adicionaAlugavel(serie);
  }

  @PostMapping("/jogos")
  public void cadastrarJogos(@RequestBody Jogo jogo) {
    controle.adicionaAlugavel(jogo);
  }

  /* DELETAR */
  @DeleteMapping("/{id}")
  public void removeFilmes(@PathVariable Integer id) {
    controle.removeAlugavel(id - 1);
  }

  @GetMapping("alugar/{id}/{dias}")
  public Aluguel alugar(@PathVariable Integer id, @PathVariable Integer dias) {
    return controle.alugar(id, dias);
  }

  public void popularLista() {
    this.controle.adicionaAlugavel(new Filme(
        "Toy Story 4",
        2019,
        "Animação",
        "Josh Cooley",
        7.8,
        100
    ));
    this.controle.adicionaAlugavel(new Filme(
        "A Origem",
        2010,
        "Ação",
        "Christopher Nolan",
        8.8,
        148
    ));
    this.controle.adicionaAlugavel(new Filme(
        "Matrix",
        1999,
        "Ação",
        "Lana Wachowski, Lilly Wachowski",
        8.7,
        136
    ));
    this.controle.adicionaAlugavel(new Serie(
        "Stranger Things",
        2016,
        "Drama, fantasia",
        "Matt e Ross Duffer",
        8.8,
        51,
        25
    ));
    this.controle.adicionaAlugavel(new Serie(
        "Game of Thrones",
        2011,
        "Ação",
        "David Benioff e D. B. Weiss",
        9.3,
        57,
        73
    ));
    this.controle.adicionaAlugavel(new Serie(
        "Fullmetal Alchemist Brotherhood",
        2009,
        "Ação",
        "Hiromu Arakawa",
        9.1,
        24,
        64
    ));
    this.controle.adicionaAlugavel(new Jogo(
        "Super Mario World",
        "Super Nintendo",
        1990,
        "Plataforma",
        8.5
    ));
    this.controle.adicionaAlugavel(new Jogo(
        "Star Fox 64",
        "Nintendo 64",
        1997,
        "Ação",
        8.7
    ));
    this.controle.adicionaAlugavel(new Jogo(
        "Sonic the Hedgehog 2",
        "Mega Drive",
        1992,
        "Plataforma",
        7.9
    ));
  }
}
