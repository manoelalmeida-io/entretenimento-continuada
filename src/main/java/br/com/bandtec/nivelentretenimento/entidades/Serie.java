package br.com.bandtec.nivelentretenimento.entidades;

import br.com.bandtec.nivelentretenimento.tipos.Genero;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Serie extends Video {

  private Integer duracaoEpisodioMinutos;
  private Integer numeroEpisodios;

  public Serie(
      String nome,
      Integer anoLancamento,
      Genero genero,
      String diretor,
      Double notaImdb,
      Integer duracaoEpisodioMinutos,
      Integer numeroEpisodios
  ) {
    super(nome, anoLancamento, genero, diretor, notaImdb);
    this.duracaoEpisodioMinutos = duracaoEpisodioMinutos;
    this.numeroEpisodios = numeroEpisodios;
  }

  @JsonGetter("horas")
  @Override
  public Double calcularHorasEntretenimento() {
    return duracaoEpisodioMinutos * numeroEpisodios / 60.0;
  }

  @Override
  public String toString() {
    return "Serie{" +
        super.toString() +
        "duracaoEpisodioMinutos=" + duracaoEpisodioMinutos +
        ", numeroEpisodios=" + numeroEpisodios +
        '}';
  }

  public Integer getDuracaoEpisodioMinutos() {
    return duracaoEpisodioMinutos;
  }

  public Integer getNumeroEpisodios() {
    return numeroEpisodios;
  }
}
