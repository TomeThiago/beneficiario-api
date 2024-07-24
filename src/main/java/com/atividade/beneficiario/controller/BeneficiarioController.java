package com.atividade.beneficiario.controller;

import com.atividade.beneficiario.controller.dto.AlteraBeneficiarioDTO;
import com.atividade.beneficiario.controller.dto.CadastraBeneficiarioDTO;
import com.atividade.beneficiario.entity.Beneficiario;
import com.atividade.beneficiario.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiario")
public class BeneficiarioController {
    @Autowired
    private BeneficiarioService beneficiarioService;

    @GetMapping
    public ResponseEntity<List<Beneficiario>> listarBeneficiarios() {
        List<Beneficiario> response = this.beneficiarioService.listaBeneficiarios();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beneficiario> mostrarBeneficiario(@PathVariable Long id) {
        Beneficiario beneficiario = this.beneficiarioService.mostrarBeneficiario(id);

        return ResponseEntity.ok(beneficiario);
    }

    @PostMapping
    public ResponseEntity<Beneficiario> cadastrarBeneficiario(@RequestBody CadastraBeneficiarioDTO dados) {
        Beneficiario response = this.beneficiarioService.cadastrarBeneficiario(dados);

        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<Beneficiario> alterarBeneficiario(@PathVariable Long id, @RequestBody AlteraBeneficiarioDTO dados) {
        Beneficiario response = this.beneficiarioService.alterarBeneficiario(id, dados);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluirBeneficiario(@PathVariable Long id) {
        this.beneficiarioService.excluirBeneficiario(id);

        return ResponseEntity.noContent().build();
    }
}
