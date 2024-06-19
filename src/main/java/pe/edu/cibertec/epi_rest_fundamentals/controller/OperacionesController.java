package pe.edu.cibertec.epi_rest_fundamentals.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.epi_rest_fundamentals.model.GeneralResponse;
import pe.edu.cibertec.epi_rest_fundamentals.service.IOperacionesService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class OperacionesController {

    private IOperacionesService iOperacionesService;
@GetMapping("/esprimo/{numero}")
    public ResponseEntity<GeneralResponse>
    validarNumeroPrimo(@PathVariable int numero){
    boolean resultado = iOperacionesService.validarNumeroEsPrimo(numero);
    String mensaje = resultado?numero + " es primo" :numero + "No es primo";
    GeneralResponse response = GeneralResponse.builder()
            .mensaje(mensaje).build();
    return new ResponseEntity<>(response, HttpStatus.OK);
    }
@GetMapping("/exponente/{num}/{expo}")
    public double elevarnUmeroAExponente(@PathVariable int num,
                                         @PathVariable int expo){
    return iOperacionesService.elevarNumeroAlExponente(num, expo);
}
@GetMapping("/primo")
     public boolean validarPrimo(@RequestParam int numero,
                                 @RequestParam(required = false)boolean filtro){
    return iOperacionesService.validarNumeroEsPrimo(numero);
}
@GetMapping("/elevarexponente")
    public double elevarNumeroAExpnenteQuery(@RequestParam  int num,
                                             @RequestParam(defaultValue = "2") int expo){
    return iOperacionesService.elevarNumeroAlExponente(num,expo);
  }
@GetMapping("/datos/{num}")
  public String listaNombre(@PathVariable int num,
                            @RequestParam List<String> nombres){
    return "Nombres: "+ String.join(",", nombres);
  }
}
