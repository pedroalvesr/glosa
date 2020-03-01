package br.com.zg.glosa.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "item_guia")
public class ItemGuia {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    @Column(name = "guia_id")
    private List<Guia> guia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Guia> getGuia() {
        return guia;
    }

    public void setGuia(List<Guia> guia) {
        this.guia = guia;
    }
}
