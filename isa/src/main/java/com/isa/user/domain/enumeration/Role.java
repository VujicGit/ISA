package com.isa.user.domain.enumeration;

public enum Role {
    SYSTEM_ADMINISTRATOR(Values.SYSTEM_ADMINISTRATOR),
    PHARMACY_ADMINISTRATOR(Values.PHARMACY_ADMINISTRATOR),
    PHARMACIST(Values.PHARMACIST),
    DERMATOLOGIST(Values.DERMATOLOGIST),
    SUPPLIER(Values.SUPPLIER),
    PATIENT(Values.PATIENT);

    Role(String value) {}

    public static class Values {
        public static final String SYSTEM_ADMINISTRATOR = "SYSTEM_ADMINISTRATOR";
        public static final String PHARMACY_ADMINISTRATOR = "PHARMACY_ADMINISTRATOR";
        public static final String PHARMACIST = "PHARMACIST";
        public static final String DERMATOLOGIST = "DERMATOLOGIST";
        public static final String SUPPLIER = "SUPPLIER";
        public static final String PATIENT = "PATIENT";
    }
}
