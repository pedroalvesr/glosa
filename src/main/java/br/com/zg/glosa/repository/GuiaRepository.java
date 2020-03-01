package br.com.zg.glosa.repository;

import br.com.zg.glosa.model.Guia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuiaRepository extends JpaRepository<Guia, Long> {

    Guia findByNumero(String numero);
}
