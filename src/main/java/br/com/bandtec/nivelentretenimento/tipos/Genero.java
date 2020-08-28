package br.com.bandtec.nivelentretenimento.tipos;

public enum Genero {
  ACAO(10),
  ANIMACAO(9),
  AVENTURA(8),
  COMEDIA(8),
  CORRIDA(7),
  DANCA(8),
  DOCUMENTARIO(4),
  DRAMA(5),
  ESPIONAGEM(7),
  FAROESTE(7),
  FANTASIA(10),
  FICCAO_CIENTIFICA(8),
  GUERRA(6),
  LUTA(8),
  MUSICAL(7),
  PLATAFORMA(10),
  POLICIAL(8),
  ROMANCE(7),
  RPG(9),
  SIMULACAO(8),
  SUSPENSE(6),
  TERROR(6),
  TIRO(8);

  private Integer pontuacao;

  Genero(Integer pontuacao) {
    this.pontuacao = pontuacao;
  }

  public Integer getPontuacao() {
    return pontuacao;
  }
}
