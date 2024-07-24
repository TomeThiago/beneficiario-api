package com.atividade.beneficiario.entity;

import com.atividade.beneficiario.controller.dto.CadastraDocumentoDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Embeddable
@Table(name="Documento")
@Entity(name = "Documento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoDocumento;
    private String descricao;
    private LocalDateTime dataInclusao;
    private LocalDateTime dataAtualizacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beneficiario_id", nullable = false)
    @JsonBackReference
    private Beneficiario beneficiario;

    public Documento(CadastraDocumentoDTO dados, Beneficiario beneficiario) {
        this.tipoDocumento = dados.tipoDocumento();
        this.descricao = dados.descricao();
        this.beneficiario = beneficiario;
        this.dataInclusao = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }
}
