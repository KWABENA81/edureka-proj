package com.sas.feems.model;

public enum FeeType {
    TUITION, EXTRACURRICULAR,NONE;

    String getType() {
        String ftype = null;
        switch (this) {
            case TUITION:
                ftype = "tuition";
            case EXTRACURRICULAR:
                ftype = "extra-curricular";
            case NONE:
                ftype = "none";
        }
        return ftype;
    }
}
