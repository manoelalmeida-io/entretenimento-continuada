package br.com.bandtec.locadora.entidades;

public class Serie extends Video {

  private Integer duracaoEpisodioMinutos;
  private Integer numeroEpisodios;

  public Serie(
      String nome,
      Integer anoLancamento,
      String genero,
      String diretor,
      Double notaImdb,
      Integer duracaoEpisodioMinutos,
      Integer numeroEpisodios
  ) {
    super(nome, anoLancamento, genero, diretor, notaImdb);
    this.duracaoEpisodioMinutos = duracaoEpisodioMinutos;
    this.numeroEpisodios = numeroEpisodios;
  }

  @Override
  public Double getPrecoAluguelPorDia() {
    if (2020 - getAnoLancamento() < 5) {
      return numeroEpisodios / 10 * (1 + getNotaImdb() / 10);
    } else {
      return numeroEpisodios/ 10 * (1 + getNotaImdb() / 10);
    }
  }

  @Override
  public Double getTotalHoras() {
    return duracaoEpisodioMinutos * numeroEpisodios / 60.0;
  }

  public Integer getDuracaoEpisodioMinutos() {
    return duracaoEpisodioMinutos;
  }

  public Integer getNumeroEpisodios() {
    return numeroEpisodios;
  }
}
