package br.com.bandtec.nivelentretenimento.entidades;

import br.com.bandtec.nivelentretenimento.Entretenimento;
import br.com.bandtec.nivelentretenimento.tipos.Genero;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Filme extends Video implements Entretenimento {

  private Integer duracaoMinutos;

  public Filme(
      String nome,
      Integer anoLancamento,
      Genero genero,
      String diretor,
      Double notaImdb,
      Integer duracaoMinutos
  ) {
    super(nome, anoLancamento, genero, diretor, notaImdb);
    this.duracaoMinutos = duracaoMinutos;
  }

  @JsonGetter("horas")
  @Override
  public Double calcularHorasEntretenimento() {
    return this.duracaoMinutos / 60.0;
  }

  @Override
  public String toString() {
    return "Filme{" +
        super.toString() +
        "duracaoMinutos=" + duracaoMinutos +
        "horasEntretenimento=" + calcularHorasEntretenimento() +
        "qualidadeEntretenimento=" + calcularQualidadeEntretenimento() +
        '}';
  }

  public Integer getDuracaoMinutos() {
    return duracaoMinutos;
  }
}
