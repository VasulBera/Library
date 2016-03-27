package org.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="publication")
public class Publication {
    // - It's moock-Class who has this entity have to fill it.
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
}
