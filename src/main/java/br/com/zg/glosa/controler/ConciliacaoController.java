package br.com.zg.glosa.controler;

import br.com.zg.glosa.model.Conciliacao;
import br.com.zg.glosa.service.IConciliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conciliacao")
public class ConciliacaoController {

    @Autowired
    private
    IConciliacaoService conciliacaoRepository;

    @PostMapping("/conciliacao")
    public boolean adicionarConciliacao(@RequestBody Conciliacao conciliacao) {
        return conciliacaoRepository.adicionarConciliacao(conciliacao);
    }

    @DeleteMapping("/conciliacao/numeroGuia")
    public void deletarConciliacao(Long numeroGuia) {
        List<Conciliacao> conciliacoesExcluir = conciliacaoRepository.carregarConciliacaoPorNumeroGuia(numeroGuia);
        conciliacaoRepository.excluirConciliacao(conciliacoesExcluir);
    }

    @GetMapping("/conciliacao")
    public List<Conciliacao> listarTodasConciliacoes() {
        return conciliacaoRepository.listarTodasConciliacaoes();
    }

    @GetMapping("/conciliacao/{numeroGuia}")
    public List<Conciliacao> carregarConciliacaoPorNumeroGuia(@PathVariable("numeroGuia") Long numeroGuia) {
        return conciliacaoRepository.carregarConciliacaoPorNumeroGuia(numeroGuia);
    }

//    @GetMapping("conciliacao/{dataPagamento}")
//    public List<Conciliacao> listarConcilicaoesPorDataPagamento(@PathVariable("dataPagamento") Date dataPagamento) {
//        return conciliacaoRepository.listarConcilicaoesPorDataPagamento(dataPagamento);
//    }

    @GetMapping("/conciliacao/{ngPrest}")
    public List<Conciliacao> listarConcilicaoesPorNgPrest(@PathVariable("ngPrest") Long ngPrest) {
        return conciliacaoRepository.listarConcilicaoesPorNgPrest(ngPrest);
    }

}