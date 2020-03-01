package br.com.zg.glosa.repository;

import br.com.zg.glosa.model.QuitacaoGuia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class Custom {
    @Autowired
    EntityManager entityManager;

    public void salvar(QuitacaoGuia quitacaoGuia) {
        entityManager.createNativeQuery("insert into (version, guia_id, data_pamento, valor_pago) values (?,?,?,?)")
                .setParameter(1, quitacaoGuia.getVersion())
                .setParameter(2, quitacaoGuia.getGuia().get(0).getId())
                .setParameter(3, quitacaoGuia.getDataPagamento())
                .setParameter(3, quitacaoGuia.getValorPago())
                .executeUpdate();
    }
}
