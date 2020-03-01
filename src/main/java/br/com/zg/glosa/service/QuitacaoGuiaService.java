package br.com.zg.glosa.service;

import br.com.zg.glosa.model.Guia;
import br.com.zg.glosa.model.QuitacaoGuia;
import br.com.zg.glosa.repository.Custpm;
import br.com.zg.glosa.repository.QuitacaoGuiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Service
public class QuitacaoGuiaService {

    @Autowired
    QuitacaoGuiaRepository quitacaoGuiaRepository;

    @Autowired
    Custpm custpm;

    public void salvar(Guia guia, Date dataPagamento, Double valorPago) {
        QuitacaoGuia quitacaoGuia = new QuitacaoGuia();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String dateString = format.format(new Date());
        try {

            Date date = format.parse(dataPagamento.toString());
            quitacaoGuia.setDataPagamento(date);

        } catch (ParseException e) {
            quitacaoGuia.setDataPagamento(new Date());
            e.printStackTrace();
        }

        quitacaoGuia.setValorPago(valorPago);
        quitacaoGuia.setGuia(Arrays.asList(guia));

        custpm.salvar(quitacaoGuia);

    }

}
