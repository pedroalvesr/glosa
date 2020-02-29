package br.com.zg.glosa.repository;

import br.com.zg.glosa.model.Conciliacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ConciliacaoRepository extends CrudRepository<Conciliacao, Long> {

    @Query("SELECT c FROM CONCILIACAO c WHERE c.DATA_PAGAMENTO = :dataPagamento")
    List<Conciliacao> listarConcilicaoesPorDataPagamento(@Param("dataPagamento") Date dataPagamento);

    @Query("SELECT c FROM CONCILIACAO c WHERE c.NUMERO_GUIA = :numeroGuia")
    List<Conciliacao> carregarConciliacaoPorNumeroGuia(@Param("numeroGuia") Long numeroGuia);

    @Query("SELECT c FROM CONCILIACAO c WHERE c.NG_PREST = :ngPrest")
    List<Conciliacao> listarConcilicaoesPorNgPrest(@Param("ngPrest") Long ngPrest);
}
