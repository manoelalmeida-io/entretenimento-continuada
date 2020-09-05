package br.com.bandtec.locadora.controller;

import br.com.bandtec.locadora.ControleAlugueis;
import br.com.bandtec.locadora.entidades.Aluguel;
import br.com.bandtec.locadora.entidades.Total;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alugueis")
public class AlugueisController {

  ControleAlugueis controle = new ControleAlugueis();

  @GetMapping
  public ResponseEntity listarAlugueis() {
    List<Aluguel> alugueis = controle.listarAlugueis();

    if (alugueis.isEmpty()) {
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok(alugueis);
  }

  @GetMapping("/{filtro}")
  public ResponseEntity filtrarAlugueis(@PathVariable String filtro) {
    List<Aluguel> alugueisFiltrados = controle.filtrarAlugueis(filtro);

    if (alugueisFiltrados.isEmpty()) {
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok(alugueisFiltrados);
  }

  @PostMapping("/{id}/{dias}")
  public ResponseEntity alugar(@PathVariable Integer id, @PathVariable Integer dias) {
    controle.alugar(CatalogoController.controle, id, dias);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/total")
  public ResponseEntity total() {
    Total total = controle.total();
    return ResponseEntity.ok(total);
  }

  @GetMapping("/total/{filtro}")
  public ResponseEntity totalFiltrado(@PathVariable String filtro) {
    Total total = controle.totalFiltrado(filtro);
    return ResponseEntity.ok(total);
  }
}
