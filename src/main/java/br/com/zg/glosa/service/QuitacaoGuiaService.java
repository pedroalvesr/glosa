package br.com.zg.glosa.service;

import br.com.zg.glosa.model.Guia;
import br.com.zg.glosa.model.QuitacaoGuia;
import br.com.zg.glosa.repository.QuitacaoGuiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

@Service
public class QuitacaoGuiaService {

    @Autowired
    QuitacaoGuiaRepository quitacaoGuiaRepository;

    public void salvar(Guia guia, Date dataPagamento, Double valorPago) {
        QuitacaoGuia quitacaoGuia = new QuitacaoGuia();

        LocalDate localDate = Instant.ofEpochMilli(dataPagamento.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        quitacaoGuia.setDataPagamento(localDate);
        quitacaoGuia.setValorPago(valorPago);
        quitacaoGuia.setGuia(Arrays.asList(guia));

        quitacaoGuiaRepository.save(quitacaoGuia);

    }

}
