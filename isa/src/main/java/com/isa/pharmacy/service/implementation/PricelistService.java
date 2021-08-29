package com.isa.pharmacy.service.implementation;

import com.isa.appointment.domain.TimePeriod;
import com.isa.drug.domain.Drug;
import com.isa.drug.service.interfaces.IDrugService;
import com.isa.pharmacy.domain.Item;
import com.isa.pharmacy.domain.Price;
import com.isa.pharmacy.domain.Pricelist;
import com.isa.pharmacy.dto.AddPriceDto;
import com.isa.pharmacy.repository.PricelistRepository;
import com.isa.pharmacy.service.interfaces.IPricelistService;
import com.isa.pharmacy.service.interfaces.IWarehouseService;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PricelistService implements IPricelistService {

    private final PricelistRepository pricelistRepository;
    private final IDrugService drugService;
    private final IWarehouseService warehouseService;

    public PricelistService(PricelistRepository pricelistRepository, IDrugService drugService, IWarehouseService warehouseService) {
        this.pricelistRepository = pricelistRepository;
        this.drugService = drugService;
        this.warehouseService = warehouseService;
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
        Drug drug = getDrugFromPharmacy(pharmacyId, addPriceDto.getDrugId());
        if(drug == null) return null;
        List<Price> prices = pricelist.getPrices();
        TimePeriod pricePeriod = new TimePeriod(addPriceDto.getStartPeriod(), addPriceDto.getEndPeriod());
        Price newPrice = new Price(addPriceDto.getPrice(), drug, pricePeriod);

        if(isPriceEqual(prices, newPrice)) return null;

        removeEqualsByPrice(prices, newPrice);

        prices.add(newPrice);
        return pricelistRepository.save(pricelist);
    }


    private void removeEqualsByPrice(List<Price> prices, Price newPrice) {
        Price equalByDate = getEqualsByPrice(prices, newPrice);
        if(equalByDate != null) {
           prices.remove(equalByDate);
        }
    }

    private Drug getDrugFromPharmacy(Long pharmacyId, Long drugId) {
        Item retVal = warehouseService.findByPharmacyId(pharmacyId).getItems().stream().
                filter(item -> item.getDrug().getId().equals(drugId)).
                findFirst().
                orElse(null);

        if(retVal == null) return null;

        return retVal.getDrug();
    }

    @Nullable
    private Price getEqualsByPrice(List<Price> prices, Price newPrice) {
        return prices.stream().filter(newPrice::isEqualByDate).findFirst().orElse(null);
    }

    private boolean isPriceEqual(List<Price> prices, Price newPrice) {
        return prices.stream().anyMatch(newPrice::equals);
    }
}
