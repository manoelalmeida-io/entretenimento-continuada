package br.com.bandtec.locadora;

import br.com.bandtec.locadora.entidades.Aluguel;
import br.com.bandtec.locadora.entidades.Filme;
import br.com.bandtec.locadora.entidades.Jogo;
import br.com.bandtec.locadora.entidades.Serie;
import java.util.ArrayList;
import java.util.List;

public class ControleCatalogo {

  private final List<Alugavel> alugaveis;

  public ControleCatalogo() {
    this.alugaveis = new ArrayList<>();
  }

  public void adicionaCatalogo(Alugavel e) {
    this.alugaveis.add(e);
  }

  public void removeCatalogo(Integer indice) {
    this.alugaveis.remove(indice.intValue());
  }

  public List<Alugavel> listarCatalogo() {
    return alugaveis;
  }

  public List<Alugavel> filtrarCatalogo(String filtro) {
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

  public Aluguel alugar(Integer indice, Integer dias) {
    return new Aluguel(this.alugaveis.get(indice), dias);
  }
}
