package br.com.zg.glosa.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "quitacao_guia")
public class QuitacaoGuia {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "version")
    private Integer version = 0;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @OneToMany
    @Column(name = "guia_id")
    private List<Guia> guia;

    @Column(name ="valor_pago")
    private Double valorPago;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public List<Guia> getGuia() {
        return guia;
    }

    public void setGuia(List<Guia> guia) {
        this.guia = guia;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }
}
