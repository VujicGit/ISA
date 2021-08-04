package com.isa.appointment.domain;

import javax.persistence.Embeddable;
import javax.xml.crypto.Data;
import java.util.Date;

@Embeddable
public class TimePeriod {

    private Date start;
    private Date end;

    public TimePeriod(){}

    public TimePeriod(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
