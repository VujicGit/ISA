package com.isa.user.exception;

import com.isa.appointment.domain.TimePeriod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShiftAlreadyExistsException extends RuntimeException{

    private String message;

    public ShiftAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    public ShiftAlreadyExistsException(TimePeriod duration) {
        super();
        this.message = createMessage(duration);
    }

    @Override
    public String getMessage() {
        return message;
    }

    private String createMessage(TimePeriod timePeriod) {
        return "The shift "
                + formatLocalDateTime(timePeriod.getStart())
                + " - "
                + formatLocalDateTime(timePeriod.getEnd())
                + " already exists";
    }

    private String formatLocalDateTime(LocalDateTime date) {
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return date.format(formatter);
    }
}
