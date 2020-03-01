package br.com.zg.glosa.repository;

import br.com.zg.glosa.model.Conciliacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ConciliacaoRepository extends CrudRepository<Conciliacao, Long> {

    @Query("SELECT c FROM Conciliacao c WHERE c.dataPagamento= :dataPagamento")
    List<Conciliacao> listarConcilicaoesPorDataPagamento(@Param("dataPagamento") Date dataPagamento);

    @Query("SELECT c FROM Conciliacao c WHERE c.numeroGuia = :numeroGuia")
    List<Conciliacao> carregarConciliacaoPorNumeroGuia(@Param("numeroGuia") Long numeroGuia);

    @Query("SELECT c FROM Conciliacao c WHERE c.ngPrest = :ngPrest")
    List<Conciliacao> listarConcilicaoesPorNgPrest(@Param("ngPrest") Long ngPrest);
}
