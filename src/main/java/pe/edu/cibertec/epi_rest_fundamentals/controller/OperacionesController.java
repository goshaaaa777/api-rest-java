package pe.edu.cibertec.epi_rest_fundamentals.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.epi_rest_fundamentals.service.IOperacionesService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class OperacionesController {

    private IOperacionesService iOperacionesService;
@GetMapping("/esprimo/{numero}")
    public boolean validarNumeroPrimo(@PathVariable int numero){
    return iOperacionesService.validarNumeroEsPrimo(numero);
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
