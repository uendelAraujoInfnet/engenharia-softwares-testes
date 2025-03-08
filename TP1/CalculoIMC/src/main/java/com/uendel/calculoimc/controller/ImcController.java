<<<<<<< HEAD
package com.uendel.calculoimc.controller;

import com.uendel.calculoimc.model.ImcRequest;
import com.uendel.calculoimc.service.ImcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/imc")
public class ImcController {

    @Autowired
    private ImcService imcService;

    @PostMapping("/calcular")
    public String calcularIMC(@RequestBody ImcRequest request) {
        double imc = imcService.calcularIMC(request.getPeso(), request.getAltura());
        return String.format("IMC: %.2f - Classificação: %s", imc, imcService.classificarIMC(imc));
    }
}
=======
package com.uendel.calculoimc.controller;

import com.uendel.calculoimc.model.ImcRequest;
import com.uendel.calculoimc.service.ImcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/imc")
public class ImcController {

    @Autowired
    private ImcService imcService;

    @PostMapping("/calcular")
    public String calcularIMC(@RequestBody ImcRequest request) {
        double imc = imcService.calcularIMC(request.getPeso(), request.getAltura());
        return String.format("IMC: %.2f - Classificação: %s", imc, imcService.classificarIMC(imc));
    }
}
>>>>>>> 03890a7ac8c4a4af8de13252e4f83983cc736942
