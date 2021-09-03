package com.isa.appointment.exception;

import com.isa.appointment.dto.ExaminationDto;

public class ExaminationException extends RuntimeException {

    public ExaminationException(String message) {
        super(message);
    }
}
