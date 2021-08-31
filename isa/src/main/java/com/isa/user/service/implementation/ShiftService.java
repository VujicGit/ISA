package com.isa.user.service.implementation;

import com.isa.appointment.domain.TimePeriod;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.repository.PharmacyRepository;
import com.isa.supplier.exception.ShiftAlreadyExistsException;
import com.isa.user.domain.Dermatologist;
import com.isa.user.domain.Employee;
import com.isa.user.domain.Shift;
import com.isa.user.dto.ShiftDto;
import com.isa.user.repository.DermatologistRepository;
import com.isa.user.repository.EmployeeRepository;
import com.isa.user.repository.ShiftRepository;
import com.isa.user.service.interfaces.IShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftService implements IShiftService {

    private ShiftRepository shiftRepository;
    private DermatologistRepository dermatologistRepository;
    private PharmacyRepository pharmacyRepository;

    @Autowired
    public ShiftService(ShiftRepository shiftRepository, DermatologistRepository dermatologistRepository, PharmacyRepository pharmacyRepository) {
        this.shiftRepository = shiftRepository;
        this.dermatologistRepository = dermatologistRepository;
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public List<Shift> getAllByEmployeeId(Long id) {
        return shiftRepository.getAllByEmployeeId(id);
    }

    @Override
    public List<Shift> getAllByEmployeeIdAndPharmacyId(Long employeeId, Long pharmacyId) {
        return shiftRepository.getAllByEmployeeIdAndPharmacyId(employeeId, pharmacyId);
    }

    @Override
    public Shift createForDermatologist(ShiftDto shiftDto) {
        Dermatologist dermatologist = dermatologistRepository.findByPharmacyId(shiftDto.getPharmacyId()).orElseThrow();
        Pharmacy pharmacy = pharmacyRepository.findById(shiftDto.getPharmacyId()).orElseThrow();

        TimePeriod duration = new TimePeriod(shiftDto.getStart(), shiftDto.getEnd());
        Shift shift = new Shift();
        shift.setDuration(duration);
        shift.setEmployee(dermatologist);
        shift.setPharmacy(pharmacy);


        if(shiftRepository.exists(shift)) throw new ShiftAlreadyExistsException("Shift already exists");
        if(isOverLapping(shift, shift.getEmployee().getId())) throw new ShiftAlreadyExistsException("Shift already exists");

        return shiftRepository.save(shift);
    }

    private boolean isOverLapping(Shift shift, Long employeeId) {
        List<Shift> shifts = shiftRepository.getAllByEmployeeId(employeeId);
        if(shifts.size() == 0) return false;
        for(Shift it : shifts) {

            boolean isBefore = shift.getDuration().getStart().isBefore(it.getDuration().getStart())
                    && shift.getDuration().getEnd().isBefore(it.getDuration().getStart());
            boolean isAfter = shift.getDuration().getStart().isAfter(it.getDuration().getEnd())
                    && shift.getDuration().getEnd().isAfter(it.getDuration().getEnd());

            if(!isAfter && !isBefore) {
                return true;
            }
        }
        return false;

    }
}
