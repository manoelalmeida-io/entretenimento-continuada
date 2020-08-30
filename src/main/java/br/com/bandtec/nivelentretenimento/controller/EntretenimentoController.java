package br.com.bandtec.nivelentretenimento.controller;

import br.com.bandtec.nivelentretenimento.ControleEntretenimento;
import br.com.bandtec.nivelentretenimento.Entretenimento;
import br.com.bandtec.nivelentretenimento.entidades.Filme;
import br.com.bandtec.nivelentretenimento.entidades.Jogo;
import br.com.bandtec.nivelentretenimento.entidades.Serie;

import br.com.bandtec.nivelentretenimento.tipos.Dificuldade;
import br.com.bandtec.nivelentretenimento.tipos.Genero;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entretenimentos")
public class EntretenimentoController {

  ControleEntretenimento controle = new ControleEntretenimento();

  /* LISTAR */
  @GetMapping
  public List<Entretenimento> todos() {
    if (controle.todos().isEmpty()) {
      this.popularLista();
    }

    return controle.todos();
  }

  @GetMapping("/filtrar/{filtro}")
  public List<Entretenimento> filtrar(@PathVariable String filtro) {
    if (controle.filtrar(filtro).isEmpty()) {
      this.popularLista();
    }

    return controle.filtrar(filtro);
  }

  /* CADASTRAR */
  @PostMapping("/filmes")
  public void cadastrarFilme(@RequestBody Filme filme) {
    controle.adicionaEntretenimento(filme);
  }

  @PostMapping("/series")
  public void cadastrarSerie(@RequestBody Serie serie) {
    controle.adicionaEntretenimento(serie);
  }

  @PostMapping("/jogos")
  public void cadastrarJogos(@RequestBody Jogo jogo) {
    controle.adicionaEntretenimento(jogo);
  }

  /* DELETAR */
  @DeleteMapping("/{id}")
  public void removeFilmes(@PathVariable Integer id) {
    controle.removeEntretenimento(id - 1);
  }

  /* OUTROS */
  @GetMapping("/qualidade/{qualidade}")
  public List<Entretenimento> qualidadeAcima(@PathVariable Double qualidade) {
    return controle.filtrarQualidadeAcima(qualidade);
  }

  @GetMapping("/qualidade/media")
  public Double mediaQualidade() {
    return controle.mediaQualidade();
  }

  @GetMapping("/total/horas")
  public Double totalHoras() {
    return controle.totalHoras();
  }

  public void popularLista() {
    this.controle.adicionaEntretenimento(new Filme(
        "Toy Story 4",
        2019,
        Genero.ANIMACAO,
        "Josh Cooley",
        7.8,
        100
    ));
    this.controle.adicionaEntretenimento(new Filme(
        "A Origem",
        2010,
        Genero.ACAO,
        "Christopher Nolan",
        8.8,
        148
    ));
    this.controle.adicionaEntretenimento(new Filme(
        "Matrix",
        1999,
        Genero.ACAO,
        "Lana Wachowski, Lilly Wachowski",
        8.7,
        136
    ));
    this.controle.adicionaEntretenimento(new Serie(
        "Stranger Things",
        2016,
        Genero.FANTASIA,
        "Matt e Ross Duffer",
        8.8,
        51,
        25
    ));
    this.controle.adicionaEntretenimento(new Serie(
        "Game of Thrones",
        2011,
        Genero.ACAO,
        "David Benioff e D. B. Weiss",
        9.3,
        57,
        73
    ));
    this.controle.adicionaEntretenimento(new Serie(
        "Fullmetal Alchemist Brotherhood",
        2009,
        Genero.ANIMACAO,
        "Hiromu Arakawa",
        9.1,
        24,
        64
    ));
    this.controle.adicionaEntretenimento(new Jogo(
        "Super Mario World",
        "Super Nintendo",
        1990,
        Genero.PLATAFORMA,
        8.5,
        96,
        Dificuldade.NORMAL
    ));
    this.controle.adicionaEntretenimento(new Jogo(
        "Star Fox 64",
        "Nintendo 64",
        1997,
        Genero.ACAO,
        8.7,
        15,
        Dificuldade.NORMAL
    ));
    this.controle.adicionaEntretenimento(new Jogo(
        "Sonic the Hedgehog 2",
        "Mega Drive",
        1992,
        Genero.PLATAFORMA,
        7.9,
        11,
        Dificuldade.FACIL
    ));
  }
}
