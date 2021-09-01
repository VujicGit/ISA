package com.isa.user.controller;

import com.isa.helper.error.ErrorMapper;
import com.isa.helper.http.Message;
import com.isa.user.domain.Shift;
import com.isa.user.dto.ShiftDto;
import com.isa.user.mapper.ShiftMapper;
import com.isa.user.service.interfaces.IShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shift")
public class ShiftController {

    private final IShiftService shiftService;

    @Autowired
    public ShiftController(IShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @GetMapping("/employeeId/{employeeId}")
    public ResponseEntity<?> findAllByEmployeeId(@PathVariable Long employeeId) {
        List<Shift> shifts = shiftService.getAllByEmployeeId(employeeId);
        List<ShiftDto> dtos = ShiftMapper.mapShiftsToShiftDtos(shifts);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_PHARMACY_ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody ShiftDto dto, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>(ErrorMapper.Map(result.getAllErrors()), HttpStatus.BAD_REQUEST);
        }

        Shift shift = shiftService.createForDermatologist(dto);


        return new ResponseEntity<>(new Message("Success"), HttpStatus.CREATED);
    }
}
