package com.isa.pharmacy.service.implementation;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.dto.PharmacyDto;
import com.isa.pharmacy.repository.PharmacyRepository;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import com.isa.user.domain.Address;
import com.isa.user.domain.City;
import com.isa.user.domain.Country;
import com.isa.user.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyService implements IPharmacyService {

    private final PharmacyRepository pharmacyRepository;

    @Autowired
    public PharmacyService(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public Pharmacy getById(Long pharmacyId) {
        return pharmacyRepository.findById(pharmacyId).orElse(new Pharmacy());
    }

    @Override
    public Pharmacy findById(Long pharmacyId) {
        return pharmacyRepository.findById(pharmacyId).orElseThrow();
    }

    @Override
    public List<Pharmacy> findAll() {
        return pharmacyRepository.findAll();
    }

    @Override
    public Pharmacy update(PharmacyDto pharmacyDto) {
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyDto.getId()).orElseThrow();
        Country country = new Country();
        country.setName(pharmacyDto.getCountry());

        City city = new City();
        city.setName(pharmacyDto.getCity());
        city.setZipCode(pharmacyDto.getZipCode());
        city.setCountry(country);

        Location location = new Location();
        location.setLatitude(pharmacyDto.getLatitude());
        location.setLongitude(pharmacyDto.getLongitude());

        Address address = new Address();
        address.setLocation(location);
        address.setCity(city);
        address.setStreet(pharmacyDto.getAddress());
        //TODO: number

        pharmacy.setAddress(address);
        pharmacy.setDescription(pharmacyDto.getDescription());

        return pharmacyRepository.save(pharmacy);

    }


}
