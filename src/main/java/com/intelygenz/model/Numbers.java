package com.intelygenz.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Numbers {
    @Id
    private long id;
    private String integers;

    public Numbers() {
    }

    public Numbers(long id, String integers){
        this.id=id;
        this.integers=integers;
    }

    public String getIntegers(){
        return this.integers;
    }

}
