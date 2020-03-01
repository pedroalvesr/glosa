package br.com.zg.glosa.repository;

import br.com.zg.glosa.model.Guia;
import br.com.zg.glosa.model.ItemGuia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemGuiaRepository extends JpaRepository<ItemGuia, Long> {

    ItemGuia findByGuia(Guia guia);
}
