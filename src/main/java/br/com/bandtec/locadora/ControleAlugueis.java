package br.com.bandtec.locadora;

import br.com.bandtec.locadora.entidades.Aluguel;
import br.com.bandtec.locadora.entidades.Filme;
import br.com.bandtec.locadora.entidades.Jogo;
import br.com.bandtec.locadora.entidades.Serie;
import br.com.bandtec.locadora.entidades.Total;
import java.util.ArrayList;
import java.util.List;

public class ControleAlugueis {

  private final List<Aluguel> alugueis;

  public ControleAlugueis() {
    this.alugueis = new ArrayList<>();
  }

  public List<Aluguel> listarAlugueis() {
    return alugueis;
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

  public void alugar(ControleCatalogo alugaveis, Integer id, Integer dias) {
    alugueis.add(alugaveis.alugar(id, dias));
  }

  public Total total() {
    Double totalValor = 0.0;
    Integer totalItens = 0;

    for (Aluguel aluguel : alugueis) {
      totalValor += aluguel.getPrecoTotal();
      totalItens++;
    }

    return new Total(totalValor, totalItens);
  }

  public Total totalFiltrado(String filtro) {
    Double totalValor = 0.0;
    Integer totalItens = 0;

    for (Aluguel aluguel : alugueis) {
      if (filtro.equals("filmes") && aluguel.getItemAlugado() instanceof Filme) {
        totalValor += aluguel.getPrecoTotal();
        totalItens++;
      }
      else if (filtro.equals("series") && aluguel.getItemAlugado() instanceof Serie) {
        totalValor += aluguel.getPrecoTotal();
        totalItens++;
      }
      else if (filtro.equals("jogos") && aluguel.getItemAlugado() instanceof Jogo) {
        totalValor += aluguel.getPrecoTotal();
        totalItens++;
      }
    }

    return new Total(totalValor, totalItens);
  }
}
