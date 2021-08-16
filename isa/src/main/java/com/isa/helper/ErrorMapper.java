package com.isa.helper;

import org.springframework.validation.ObjectError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ErrorMapper {

    public static Collection<Error> Map(List<ObjectError> errors) {
        Collection<Error> errorMessages = new ArrayList<>();
        for (ObjectError error : errors) {
            errorMessages.add(new Error(error.getDefaultMessage()));
        }
        return errorMessages;
    }
}
