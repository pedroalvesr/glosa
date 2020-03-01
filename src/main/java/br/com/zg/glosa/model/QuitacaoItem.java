package br.com.zg.glosa.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "quitacao_item")
public class QuitacaoItem {


    @Id
    @GeneratedValue
    private Long id;

    private Integer version = 0;

    private Double valor;

    @Column(name = "motivo_glosa_descricao")
    private String motivoGlosaDescricao;

    @OneToMany
    @Column(name = "item_guia_id")
    private List<ItemGuia> itemGuia;

    @Column(name = "motivo_glosa_codigo")
    private Long motivoGlosaCodigo;

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getMotivoGlosaDescricao() {
        return motivoGlosaDescricao;
    }

    public void setMotivoGlosaDescricao(String motivoGlosaDescricao) {
        this.motivoGlosaDescricao = motivoGlosaDescricao;
    }

    public List<ItemGuia> getItemGuia() {
        return itemGuia;
    }

    public void setItemGuia(List<ItemGuia> itemGuia) {
        this.itemGuia = itemGuia;
    }

    public Long getMotivoGlosaCodigo() {
        return motivoGlosaCodigo;
    }

    public void setMotivoGlosaCodigo(Long motivoGlosaCodigo) {
        this.motivoGlosaCodigo = motivoGlosaCodigo;
    }
}
