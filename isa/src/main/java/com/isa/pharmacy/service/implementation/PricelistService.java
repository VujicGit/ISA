package com.isa.pharmacy.service.implementation;

import com.isa.appointment.domain.TimePeriod;
import com.isa.drug.domain.Drug;
import com.isa.drug.service.interfaces.IDrugService;
import com.isa.pharmacy.domain.Price;
import com.isa.pharmacy.domain.Pricelist;
import com.isa.pharmacy.dto.AddPriceDto;
import com.isa.pharmacy.dto.PriceDto;
import com.isa.pharmacy.repository.PricelistRepository;
import com.isa.pharmacy.service.interfaces.IPricelistService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PricelistService implements IPricelistService {

    private final PricelistRepository pricelistRepository;
    private final IDrugService drugService;

    public PricelistService(PricelistRepository pricelistRepository, IDrugService drugService) {
        this.pricelistRepository = pricelistRepository;
        this.drugService = drugService;
    }

    @Override
    public List<Price> getPricesByPharmacyId(Long pharmacyId) {
        Pricelist pricelist = pricelistRepository.getPricelistByPharmacyId(pharmacyId);
        if(pricelist == null) return new ArrayList<>();

        return pricelist.getPrices();
    }

    @Override
    public Pricelist addPrice(Long pharmacyId, AddPriceDto addPriceDto) {
        Pricelist pricelist = pricelistRepository.getPricelistByPharmacyId(pharmacyId);
        Drug drug = drugService.findById(addPriceDto.getDrugId());
        List<Price> prices = pricelist.getPrices();
        TimePeriod pricePeriod = new TimePeriod(addPriceDto.getStartPeriod(), addPriceDto.getEndPeriod());
        Price newPrice = new Price(addPriceDto.getPrice(), drug, pricePeriod);
        boolean isEqual = prices.stream().anyMatch(newPrice::equals);
        if(isEqual) return null;

        Price isEqualByDate = prices.stream().filter(newPrice::isEqualByDate).findFirst().orElse(null);

        if(isEqualByDate != null) {
           prices.remove(isEqualByDate);
        }
        prices.add(newPrice);
        return pricelistRepository.save(pricelist);
    }
}
