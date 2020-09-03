package br.com.bandtec.locadora.entidades;

import br.com.bandtec.locadora.Alugavel;

public abstract class Video implements Alugavel {

  private String nome;
  private Integer anoLancamento;
  private String genero;
  private String diretor;
  private Double notaImdb;

  public Video(
      String nome,
      Integer anoLancamento,
      String genero,
      String diretor,
      Double notaImdb
  ) {
    this.nome = nome;
    this.anoLancamento = anoLancamento;
    this.genero = genero;
    this.diretor = diretor;
    this.notaImdb = notaImdb;
  }

  public abstract Double getTotalHoras();

  @Override
  public String toString() {
    return "Video{" +
        "nome='" + nome + '\'' +
        ", anoLancamento=" + anoLancamento +
        ", genero=" + genero +
        ", diretor='" + diretor + '\'' +
        ", notaImdb=" + notaImdb +
        '}';
  }

  public String getNome() {
    return nome;
  }

  public Integer getAnoLancamento() {
    return anoLancamento;
  }

  public String getGenero() {
    return genero;
  }

  public String getDiretor() {
    return diretor;
  }

  public Double getNotaImdb() {
    return notaImdb;
  }
}
