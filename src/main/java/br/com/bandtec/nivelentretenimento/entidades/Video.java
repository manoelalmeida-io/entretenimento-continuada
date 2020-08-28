package br.com.bandtec.nivelentretenimento.entidades;

import br.com.bandtec.nivelentretenimento.Entretenimento;
import br.com.bandtec.nivelentretenimento.tipos.Genero;
import com.fasterxml.jackson.annotation.JsonGetter;

public abstract class Video implements Entretenimento {

  private String nome;
  private Integer anoLancamento;
  private Genero genero;
  private String diretor;
  private Double notaImdb;

  public Video(
      String nome,
      Integer anoLancamento,
      Genero genero,
      String diretor,
      Double notaImdb
  ) {
    this.nome = nome;
    this.anoLancamento = anoLancamento;
    this.genero = genero;
    this.diretor = diretor;
    this.notaImdb = notaImdb;
  }

  @JsonGetter("qualidade")
  @Override
  public Double calcularQualidadeEntretenimento() {
    return getNotaImdb() * 2 * getGenero().getPontuacao();
  }

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

  public Genero getGenero() {
    return genero;
  }

  public String getDiretor() {
    return diretor;
  }

  public Double getNotaImdb() {
    return notaImdb;
  }
}
