package br.com.zg.glosa.service;

import br.com.zg.glosa.model.Guia;
import br.com.zg.glosa.model.QuitacaoItem;
import br.com.zg.glosa.repository.ItemGuiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class QuitacaoItemService {

    @Autowired
    ItemGuiaRepository itemGuiaRepository;

    public QuitacaoItem salvar(Guia guia, Double valor, Long motivoCodigo, String motivoDescricao) {
        QuitacaoItem item = new QuitacaoItem();

        item.setValor(valor);
        item.setMotivoGlosaCodigo(motivoCodigo);
        item.setMotivoGlosaDescricao(motivoDescricao);
        item.setItemGuia(Arrays.asList(itemGuiaRepository.findByGuia(guia)));

        return item;
    }


}
