package br.com.bandtec.locadora.entidades;

import br.com.bandtec.locadora.Alugavel;

public class Aluguel {

  private Alugavel itemAlugado;
  private Integer dias;

  public Aluguel(Alugavel itemAlugado, Integer dias) {
    this.itemAlugado = itemAlugado;
    this.dias = dias;
  }

  public Alugavel getItemAlugado() {
    return itemAlugado;
  }

  public Integer getDias() {
    return dias;
  }

  public Double getPrecoTotal() {
    return dias * itemAlugado.getPrecoAluguelPorDia();
  }
}
