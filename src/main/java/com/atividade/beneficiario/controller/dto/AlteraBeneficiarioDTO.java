package com.atividade.beneficiario.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Date;
import java.util.List;

public record AlteraBeneficiarioDTO(
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String telefone,
        @NotBlank
        Date dataNascimento,

        List<CadastraDocumentoDTO> documentos
) { }
