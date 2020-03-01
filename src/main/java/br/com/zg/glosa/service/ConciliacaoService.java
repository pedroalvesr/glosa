package br.com.zg.glosa.service;

import br.com.zg.glosa.model.Conciliacao;
import br.com.zg.glosa.repository.ConciliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConciliacaoService implements IConciliacaoService {

    @Autowired
    private ConciliacaoRepository conciliacaoRepository;

//    @Override
//    public List<Conciliacao> listarConcilicaoesPorDataPagamento(Date dataPagamento) {
//        return conciliacaoRepository.listarConcilicaoesPorDataPagamento(dataPagamento);
//    }

    @Override
    public List<Conciliacao> listarConcilicaoesPorNgPrest(Long ngPrest) {
        return conciliacaoRepository.listarConcilicaoesPorNgPrest(ngPrest);
    }

    @Override
    public List<Conciliacao> carregarConciliacaoPorNumeroGuia(Long numeroGuia) {
        return conciliacaoRepository.carregarConciliacaoPorNumeroGuia(numeroGuia);
    }

    @Override
    public boolean adicionarConciliacao(Conciliacao conciliacao) {
        return conciliacaoRepository.save(conciliacao) != null;
    }

    @Override
    public void excluirConciliacao(List<Conciliacao> conciliacao) {
        conciliacaoRepository.deleteAll(conciliacao);
    }

    @Override
    public List<Conciliacao> listarTodasConciliacaoes() {
        List<Conciliacao> conciliacoes = new ArrayList<>();
        conciliacaoRepository.findAll().forEach(e -> conciliacoes.add(e));
        return conciliacoes;
    }
}
