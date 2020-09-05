package br.com.bandtec.locadora.entidades;

public class Total {

  private Double totalArrecadado;
  private Integer totalItens;

  public Total(Double totalArrecadado, Integer totalItens) {
    this.totalArrecadado = totalArrecadado;
    this.totalItens = totalItens;
  }

  public Double getTotalArrecadado() {
    return totalArrecadado;
  }

  public Integer getTotalItens() {
    return totalItens;
  }
}
