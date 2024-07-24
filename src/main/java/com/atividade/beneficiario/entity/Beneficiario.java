package com.atividade.beneficiario.entity;

import com.atividade.beneficiario.controller.dto.AlteraBeneficiarioDTO;
import com.atividade.beneficiario.controller.dto.CadastraBeneficiarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name="Beneficiario")
@Entity(name = "Beneficiario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private Date dataNascimento;
    private LocalDateTime dataInclusao;
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Documento> documentos = new ArrayList<>();

    public Beneficiario(CadastraBeneficiarioDTO dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.dataNascimento = dados.dataNascimento();
        this.dataInclusao = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();

        if (dados.documentos() != null) {
            for (var docDTO : dados.documentos()) {
                Documento documento = new Documento(docDTO, this);

                this.documentos.add(documento);
            }
        }
    }

    public void atualizarInformacoes(AlteraBeneficiarioDTO dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }

       if(dados.dataNascimento() != null) {
           this.dataNascimento = dados.dataNascimento();
       }

       if(dados.documentos() != null) {
           this.documentos.clear();

           for (var docDTO : dados.documentos()) {
               Documento documento = new Documento(docDTO, this);

               this.documentos.add(documento);
           }
       }

        this.dataAtualizacao = LocalDateTime.now();
    }
}
