package com.isa.appointment.domain.enums;

public enum AppointmentType {
    EXAMINATION(Values.Examination),
    CONSULTATION(Values.Consultation);

    AppointmentType(String value) {

    }

    public static class Values {
        public static final String Consultation = "Consultation";
        public static final String Examination = "Examination";
    }
}
