package com.sas.feems.model;

public enum FeeType {
    TUITION, BOARDING;

    String getType() {
        String type = null;
        switch (this) {
            case TUITION:
                type = "tuition";
            case BOARDING:
                type = "boarding";
        }
        return type;
    }
    }
