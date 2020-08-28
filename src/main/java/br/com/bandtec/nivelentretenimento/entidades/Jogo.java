package br.com.bandtec.nivelentretenimento.entidades;

import br.com.bandtec.nivelentretenimento.Entretenimento;
import br.com.bandtec.nivelentretenimento.tipos.Dificuldade;
import br.com.bandtec.nivelentretenimento.tipos.Genero;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Jogo implements Entretenimento {

  private String nome;
  private String plataforma;
  private Integer anoLancamento;
  private Genero genero;
  private Double notaIgn;
  private Integer quantidadeFases;
  private Dificuldade dificuldade;

  public Jogo(
      String nome,
      String plataforma,
      Integer anoLancamento,
      Genero genero,
      Double notaIgn,
      Integer quantidadeFases,
      Dificuldade dificuldade
  ) {
    this.nome = nome;
    this.plataforma = plataforma;
    this.anoLancamento = anoLancamento;
    this.genero = genero;
    this.notaIgn = notaIgn;
    this.quantidadeFases = quantidadeFases;
    this.dificuldade = dificuldade;
  }

  @JsonGetter("horas")
  @Override
  public Double calcularHorasEntretenimento() {
    return quantidadeFases * 0.20 * dificuldade.getValor();
  }

  @JsonGetter("qualidade")
  @Override
  public Double calcularQualidadeEntretenimento() {
    return getNotaIgn() * 2 * getGenero().getPontuacao() / dificuldade.getValor();
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

  public Genero getGenero() {
    return genero;
  }

  public Double getNotaIgn() {
    return notaIgn;
  }

  public Integer getQuantidadeFases() {
    return quantidadeFases;
  }
}
