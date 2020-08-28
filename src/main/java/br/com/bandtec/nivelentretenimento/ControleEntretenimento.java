package br.com.bandtec.nivelentretenimento;

import br.com.bandtec.nivelentretenimento.entidades.Filme;
import br.com.bandtec.nivelentretenimento.entidades.Jogo;
import br.com.bandtec.nivelentretenimento.entidades.Serie;
import br.com.bandtec.nivelentretenimento.tipos.Dificuldade;
import br.com.bandtec.nivelentretenimento.tipos.Genero;
import java.util.ArrayList;
import java.util.List;

public class ControleEntretenimento {

  private List<Entretenimento> entretenimentos;

  public ControleEntretenimento() {
    this.entretenimentos = new ArrayList<>();
    this.entretenimentos.add(new Filme("a", 1, Genero.ACAO, "a", 9.9, 90));
    this.entretenimentos.add(new Serie("b", 1, Genero.ANIMACAO, "b", 9.2, 60, 40));
    this.entretenimentos.add(new Jogo("c", "Super Nintendo", 1, Genero.PLATAFORMA, 10.0, 15, Dificuldade.NORMAL));
  }

  public void adicionaEntretenimento(Entretenimento e) {
    this.entretenimentos.add(e);
  }

  public void removeEntretenimento(Integer indice) {
    this.entretenimentos.remove(indice.intValue());
  }

  public List<Entretenimento> todos() {
    return entretenimentos;
  }

  public List<Entretenimento> filtrar(String filtro) {
    List<Entretenimento> filtrados = new ArrayList<>();
    for (Entretenimento entretenimento : entretenimentos) {
      if (filtro.equals("filmes") && entretenimento instanceof Filme) {
        filtrados.add(entretenimento);
      }
      else if (filtro.equals("series") && entretenimento instanceof Serie) {
        filtrados.add(entretenimento);
      }
      else if (filtro.equals("jogos") && entretenimento instanceof Jogo) {
        filtrados.add(entretenimento);
      }
    }
    return filtrados;
  }

  public List<Entretenimento> todosSeries() {
    List<Entretenimento> filmes = new ArrayList<>();
    for (Entretenimento entretenimento : entretenimentos) {
      if (entretenimento instanceof Serie) {
        filmes.add(entretenimento);
      }
    }
    return filmes;
  }

  public List<Entretenimento> todosJogos() {
    List<Entretenimento> filmes = new ArrayList<>();
    for (Entretenimento entretenimento : entretenimentos) {
      if (entretenimento instanceof Jogo) {
        filmes.add(entretenimento);
      }
    }
    return filmes;
  }

  public List<Entretenimento> filtrarQualidadeAcima(Double qualidade) {
    List<Entretenimento> filtrados = new ArrayList<>();
    for (Entretenimento entretenimento : entretenimentos) {
      if (entretenimento.calcularQualidadeEntretenimento() > qualidade) {
        filtrados.add(entretenimento);
      }
    }
    return filtrados;
  }

  public Double mediaQualidade() {
    Double soma = 0.0;

    for (Entretenimento entretenimento : entretenimentos) {
      soma += entretenimento.calcularQualidadeEntretenimento();
    }

    return soma / entretenimentos.size();
  }

  public Double totalHoras() {
    Double soma = 0.0;

    for (Entretenimento entretenimento : entretenimentos) {
      soma += entretenimento.calcularHorasEntretenimento();
    }

    return soma;
  }
}
