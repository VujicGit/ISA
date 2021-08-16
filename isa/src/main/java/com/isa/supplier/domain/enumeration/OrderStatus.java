package com.isa.supplier.domain.enumeration;


public enum OrderStatus {
    PENDING,
    ACCEPTED,
    REJECTED;

    public static OrderStatus intConverter(Integer intStatus) {
        if(intStatus == 0) return PENDING;
        if(intStatus == 1)  return ACCEPTED;
        if(intStatus == 2)  return REJECTED;

        return PENDING;
    }

    @Override
    public String toString() {
        if(this == OrderStatus.PENDING) {
            return "Pending";
        }
        else if(this == OrderStatus.ACCEPTED) {
            return "Accepted";
        }
        else {
            return "Rejected";
        }
    }
}
