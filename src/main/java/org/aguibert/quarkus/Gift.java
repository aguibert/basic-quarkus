package org.aguibert.quarkus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;

@Entity
@NamedQuery(name = "Gifts.findAll",
    query = "SELECT g FROM Gift g ORDER BY g.id",
    hints = @QueryHint(name = "org.hibernate.cacheable", value = "true") )
public class Gift {
    
    private Long id;
    private String name;

    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="giftSeq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}