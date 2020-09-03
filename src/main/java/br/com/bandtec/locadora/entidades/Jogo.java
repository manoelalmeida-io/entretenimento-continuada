package br.com.bandtec.locadora.entidades;

import br.com.bandtec.locadora.Alugavel;

public class Jogo implements Alugavel {

  private String nome;
  private String plataforma;
  private Integer anoLancamento;
  private String genero;
  private Double notaIgn;

  public Jogo(
      String nome,
      String plataforma,
      Integer anoLancamento,
      String genero,
      Double notaIgn
  ) {
    this.nome = nome;
    this.plataforma = plataforma;
    this.anoLancamento = anoLancamento;
    this.genero = genero;
    this.notaIgn = notaIgn;
  }

  @Override
  public Double getPrecoAluguelPorDia() {
    if (2020 - getAnoLancamento() < 5) {
      return 8 * (1 + getNotaIgn() / 10);
    } else if (2020 - getAnoLancamento() < 10) {
      return 6 * (1 + getNotaIgn() / 10);
    } else {
      return 4 * (1 + getNotaIgn() / 10);
    }
  }

  public String getNome() {
    return nome;
  }

  public String getPlataforma() {
    return plataforma;
  }

  public Integer getAnoLancamento() {
    return anoLancamento;
  }

  public String getGenero() {
    return genero;
  }

  public Double getNotaIgn() {
    return notaIgn;
  }

}
