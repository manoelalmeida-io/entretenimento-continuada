package br.com.bandtec.locadora.entidades;

public class Filme extends Video {

  private Integer duracaoMinutos;

  public Filme(
      String nome,
      Integer anoLancamento,
      String genero,
      String diretor,
      Double notaImdb,
      Integer duracaoMinutos
  ) {
    super(nome, anoLancamento, genero, diretor, notaImdb);
    this.duracaoMinutos = duracaoMinutos;
  }

  @Override
  public Double getPrecoAluguelPorDia() {
    if (2020 - getAnoLancamento() < 5) {
      return 7 * (1 + getNotaImdb() / 10);
    } else {
      return 5 * (1 + getNotaImdb() / 10);
    }
  }

  @Override
  public Double getTotalHoras() {
    return this.duracaoMinutos / 60.0;
  }

  public Integer getDuracaoMinutos() {
    return duracaoMinutos;
  }
}
