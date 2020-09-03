package br.com.bandtec.locadora;

import br.com.bandtec.locadora.entidades.Aluguel;
import br.com.bandtec.locadora.entidades.Filme;
import br.com.bandtec.locadora.entidades.Jogo;
import br.com.bandtec.locadora.entidades.Serie;
import java.util.ArrayList;
import java.util.List;

public class ControleAluguel {

  private List<Alugavel> alugaveis;
  private List<Aluguel> alugueis;

  public ControleAluguel() {
    this.alugaveis = new ArrayList<>();
    this.alugueis = new ArrayList<>();
  }

  public void adicionaAlugavel(Alugavel e) {
    this.alugaveis.add(e);
  }

  public void removeAlugavel(Integer indice) {
    this.alugaveis.remove(indice.intValue());
  }

  public List<Alugavel> listarAlugaveis() {
    return alugaveis;
  }

  public List<Aluguel> listarAlugueis() {
    return alugueis;
  }

  public List<Alugavel> filtrarAlugaveis(String filtro) {
    List<Alugavel> filtrados = new ArrayList<>();
    for (Alugavel alugavel : alugaveis) {
      if (filtro.equals("filmes") && alugavel instanceof Filme) {
        filtrados.add(alugavel);
      }
      else if (filtro.equals("series") && alugavel instanceof Serie) {
        filtrados.add(alugavel);
      }
      else if (filtro.equals("jogos") && alugavel instanceof Jogo) {
        filtrados.add(alugavel);
      }
    }
    return filtrados;
  }

  public List<Aluguel> filtrarAlugueis(String filtro) {
    List<Aluguel> filtrados = new ArrayList<>();
    for (Aluguel aluguel : alugueis) {
      if (filtro.equals("filmes") && aluguel.getItemAlugado() instanceof Filme) {
        filtrados.add(aluguel);
      }
      else if (filtro.equals("series") && aluguel.getItemAlugado() instanceof Serie) {
        filtrados.add(aluguel);
      }
      else if (filtro.equals("jogos") && aluguel.getItemAlugado() instanceof Jogo) {
        filtrados.add(aluguel);
      }
    }
    return filtrados;
  }

  public Aluguel alugar(Integer indice, Integer dias) {
    Aluguel novoAluguel = new Aluguel(this.alugaveis.get(indice), dias);
    this.alugueis.add(novoAluguel);
    return novoAluguel;
  }
}
