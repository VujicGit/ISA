package com.isa.supplier.service.implementation;

import com.isa.drug.domain.Drug;
import com.isa.drug.repository.DrugRepository;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.repository.PharmacyRepository;
import com.isa.supplier.domain.Order;
import com.isa.supplier.domain.OrderedDrug;
import com.isa.supplier.domain.enumeration.OrderStatus;
import com.isa.supplier.dto.CreateOrderDto;
import com.isa.supplier.dto.CreateOrderedDrugDto;
import com.isa.supplier.repository.OrderRepository;
import com.isa.supplier.service.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final DrugRepository drugRepository;
    private final PharmacyRepository pharmacyRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, DrugRepository drugRepository, PharmacyRepository pharmacyRepository) {
        this.orderRepository = orderRepository;
        this.drugRepository = drugRepository;
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order save(CreateOrderDto createOrderDto, Long pharmacyId, Long pharmacyAdmin) {
        List<OrderedDrug> orderedDrugs = getOrderedDrugs(createOrderDto);
        Pharmacy pharmacy = pharmacyRepository.getById(pharmacyId);
        Order newOrder = new Order();
        newOrder.setDueDate(new Date());
        newOrder.setDueDate(new Date());
        newOrder.setOrderedDrug(orderedDrugs);
        newOrder.setStatus(OrderStatus.PENDING);
        newOrder.setPharmacy(pharmacy);
        return orderRepository.save(newOrder);
    }

    @Override
    public List<Order> findAllByPharmacyId(Long pharmacyId) {
        return orderRepository.findAllByPharmacyId(pharmacyId);
    }


    private List<OrderedDrug> getOrderedDrugs(CreateOrderDto createOrderDto) {
        List<CreateOrderedDrugDto> orderDrugDtos = createOrderDto.getOrderedDrugs();
        List<OrderedDrug> orderedDrugs = new ArrayList<>();
        for(CreateOrderedDrugDto it : orderDrugDtos) {
            Drug drug = drugRepository.getById(it.getDrugId());
            OrderedDrug orderedDrug = new OrderedDrug(it.getQuantity(), drug);
            orderedDrugs.add(orderedDrug);
        }
        return orderedDrugs;
    }
}
