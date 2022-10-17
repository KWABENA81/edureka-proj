package com.sas.feems.model;

public enum FeeStatus {
    FULL,
    PARTIAL,
    DEFAULTED,
    NONE;

    String getStatus() {
        String status = null;
        switch (this) {
            case FULL:
                status = "full";
            case PARTIAL:
                status = "partial";
            case DEFAULTED:
                status = "defaulted";
            case NONE:
                status = "none";
        }
        return status;
    }
}
