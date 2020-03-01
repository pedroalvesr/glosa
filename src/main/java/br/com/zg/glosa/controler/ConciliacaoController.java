package br.com.zg.glosa.controler;

import br.com.zg.glosa.jobs.InsercaoArquivosJob;
import br.com.zg.glosa.model.Conciliacao;
import br.com.zg.glosa.service.GuiaService;
import br.com.zg.glosa.service.IConciliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conciliacao")
public class ConciliacaoController {

    @Autowired
    private IConciliacaoService conciliacaoRepository;

    @Autowired
    private InsercaoArquivosJob insercaoArquivosJob;

    @Autowired
    private GuiaService guiaService;

    @PostMapping("")
    public boolean adicionarConciliacao(@RequestBody Conciliacao conciliacao) {
        return conciliacaoRepository.adicionarConciliacao(conciliacao);
    }

    @DeleteMapping("/numeroGuia")
    public void deletarConciliacao(Long numeroGuia) {
        List<Conciliacao> conciliacoesExcluir = conciliacaoRepository.carregarConciliacaoPorNumeroGuia(numeroGuia);
        conciliacaoRepository.excluirConciliacao(conciliacoesExcluir);
    }

    @GetMapping("")
    public List<Conciliacao> listarTodasConciliacoes() {
        guiaService.consultarGuia();
        return conciliacaoRepository.listarTodasConciliacaoes();
    }

    @GetMapping("/{numeroGuia}")
    public List<Conciliacao> carregarConciliacaoPorNumeroGuia(@PathVariable("numeroGuia") Long numeroGuia) {
        return conciliacaoRepository.carregarConciliacaoPorNumeroGuia(numeroGuia);
    }

//    @GetMapping("conciliacao/{dataPagamento}")
//    public List<Conciliacao> listarConcilicaoesPorDataPagamento(@PathVariable("dataPagamento") Date dataPagamento) {
//        return conciliacaoRepository.listarConcilicaoesPorDataPagamento(dataPagamento);
//    }

    @GetMapping("/{ngPrest}")
    public List<Conciliacao> listarConcilicaoesPorNgPrest(@PathVariable("ngPrest") Long ngPrest) {
        return conciliacaoRepository.listarConcilicaoesPorNgPrest(ngPrest);
    }

    @GetMapping("/teste")
    public void teste() {
        insercaoArquivosJob.tratarDadosArquivos();
    }

}