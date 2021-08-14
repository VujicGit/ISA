package com.isa.supplier.domain.enumeration;

public enum OrderStatus {
    PENDING,
    ACCEPTED,
    REJECTED;

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
