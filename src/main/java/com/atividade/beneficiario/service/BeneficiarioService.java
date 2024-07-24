package com.atividade.beneficiario.service;

import com.atividade.beneficiario.controller.dto.AlteraBeneficiarioDTO;
import com.atividade.beneficiario.controller.dto.CadastraBeneficiarioDTO;
import com.atividade.beneficiario.entity.Beneficiario;
import com.atividade.beneficiario.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiarioService {
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public List<Beneficiario> listaBeneficiarios() {
        List<Beneficiario> beneficiarios = this.beneficiarioRepository.findAll();

        beneficiarios.forEach(beneficiario -> beneficiario.getNome());

        return beneficiarios;
    }

    public Beneficiario mostrarBeneficiario(Long id) {
        Beneficiario beneficiario = this.beneficiarioRepository.getReferenceById(id);

        return beneficiario;
    }

    public Beneficiario cadastrarBeneficiario(CadastraBeneficiarioDTO dados) {
        var beneficiario = new Beneficiario(dados);

        this.beneficiarioRepository.save(beneficiario);

        return beneficiario;
    }

    public Beneficiario alterarBeneficiario(Long id, AlteraBeneficiarioDTO dados) {
        var beneficiario = this.beneficiarioRepository.getReferenceById(id);

        beneficiario.atualizarInformacoes(dados);

        this.beneficiarioRepository.save(beneficiario);

        return beneficiario;
    }

    public void excluirBeneficiario(Long id) {
        this.beneficiarioRepository.deleteById(id);
    }
}
