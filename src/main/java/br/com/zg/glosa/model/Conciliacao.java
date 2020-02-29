package br.com.zg.glosa.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Conciliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private
    long id;

    private String convenio;
    private Date dataPagamento;
    private Long numeroProtocolo;
    private String matricula;
    private String nome;
    private Long numeroGuia;
    private Long ngPrest;
    private String senhaGuia;
    private Long codigoProduto;
    private String descricaoProduto;
    private Double valorApresentado;
    private Double valorPago;
    private Double valorGlosa;
    private String descricaoMotivo;
    private Long codigoMotivo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Long getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(Long numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(Long numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public Long getNgPrest() {
        return ngPrest;
    }

    public void setNgPrest(Long ngPrest) {
        this.ngPrest = ngPrest;
    }

    public String getSenhaGuia() {
        return senhaGuia;
    }

    public void setSenhaGuia(String senhaGuia) {
        this.senhaGuia = senhaGuia;
    }

    public Long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Double getValorApresentado() {
        return valorApresentado;
    }

    public void setValorApresentado(Double valorApresentado) {
        this.valorApresentado = valorApresentado;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Double getValorGlosa() {
        return valorGlosa;
    }

    public void setValorGlosa(Double valorGlosa) {
        this.valorGlosa = valorGlosa;
    }

    public String getDescricaoMotivo() {
        return descricaoMotivo;
    }

    public void setDescricaoMotivo(String descricaoMotivo) {
        this.descricaoMotivo = descricaoMotivo;
    }

    public Long getCodigoMotivo() {
        return codigoMotivo;
    }

    public void setCodigoMotivo(Long codigoMotivo) {
        this.codigoMotivo = codigoMotivo;
    }
}
