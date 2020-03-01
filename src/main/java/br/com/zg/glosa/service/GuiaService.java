package br.com.zg.glosa.service;

import br.com.zg.glosa.model.Guia;
import br.com.zg.glosa.repository.GuiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuiaService {

    @Autowired
    private GuiaRepository guiaRepository;

    public Guia consultarGuia() {
        return guiaRepository.findById(312184689L).get();
    }

    public Guia pesquisar(String numero) {
        return guiaRepository.findByNumero(numero);
    }
}
