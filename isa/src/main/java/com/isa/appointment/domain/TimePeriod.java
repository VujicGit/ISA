package com.isa.appointment.domain;

import javax.persistence.Embeddable;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class TimePeriod {

    private LocalDate start;
    private LocalDate end;

    public TimePeriod(){}

    public TimePeriod(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
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
