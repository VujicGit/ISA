package com.isa.appointment.domain;

import com.isa.pharmacy.exception.PriceTimeException;

import javax.persistence.Embeddable;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class TimePeriod {

    @NotNull(message = "Start date can not be null")
    private LocalDateTime start;
    @NotNull(message = "End date can not be null")
    private LocalDateTime end;

    public TimePeriod(){}

    public TimePeriod(LocalDateTime start, LocalDateTime end) {
        validateTimePeriod(start, end);
        this.start = start;
        this.end = end;

    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    private void validateTimePeriod(LocalDateTime start, LocalDateTime end) throws PriceTimeException {
        if(end.isBefore(start) || start.equals(end)) throw new PriceTimeException("End date must be after start date");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimePeriod period = (TimePeriod) o;
        return start.equals(period.start) && end.equals(period.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
