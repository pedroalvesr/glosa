package br.com.zg.glosa.service;

import br.com.zg.glosa.model.Conciliacao;

import java.util.List;

public interface IConciliacaoService {

    boolean adicionarConciliacao(Conciliacao conciliacao);

    void excluirConciliacao(List<Conciliacao> conciliacao);

    List<Conciliacao> listarTodasConciliacaoes();

//    List<Conciliacao> listarConcilicaoesPorDataPagamento(Date dataPagamento);

    List<Conciliacao> listarConcilicaoesPorNgPrest(Long ngPrest);

    List<Conciliacao> carregarConciliacaoPorNumeroGuia(Long numeroGuia);
}
