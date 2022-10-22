package com.sas.feems.model;

public enum FeeStatus {
    FULL,
    PARTIAL,
    DEFAULT,
    NONE;

    String getStatus() {
        String status = null;
        switch (this) {
            case FULL:
                status = "full";
            case PARTIAL:
                status = "partial";
            case DEFAULT:
                status = "default";
            case NONE:
                status = "none";
        }
        return status;
    }
}
