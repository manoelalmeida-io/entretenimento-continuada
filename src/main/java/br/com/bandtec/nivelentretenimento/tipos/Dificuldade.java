package br.com.bandtec.nivelentretenimento.tipos;

public enum Dificuldade {
  FACIL(1.2),
  NORMAL(1.0),
  DIFICIL(1.4),
  MUITO_DIFICIL(1.8);

  private Double valor;

  Dificuldade(Double valor) {
    this.valor = valor;
  }

  public Double getValor() {
    return valor;
  }
}
