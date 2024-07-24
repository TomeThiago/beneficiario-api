package com.atividade.beneficiario.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CadastraDocumentoDTO(
        @NotBlank
        String tipoDocumento,
        @NotBlank
        String descricao
) { }
