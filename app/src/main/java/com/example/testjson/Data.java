package com.example.testjson;

import java.util.Date;

public class Data {

    private Integer ID,Value;

    public Data(Integer ID, Integer Value){
        this.setID( ID );
        this.setValue( Value );
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getValue() {
        return Value;
    }

    public void setValue(Integer value) {
        Value = value;
    }
}
