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
