package com.isa.supplier.service.implementation;

import com.isa.drug.domain.Drug;
import com.isa.drug.service.interfaces.IDrugService;
import com.isa.pharmacy.domain.Item;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.Warehouse;
import com.isa.pharmacy.repository.WarehouseRepository;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import com.isa.supplier.domain.Order;
import com.isa.supplier.domain.OrderedDrug;
import com.isa.supplier.domain.enumeration.OrderStatus;
import com.isa.supplier.dto.CreateOrderDto;
import com.isa.supplier.dto.CreateOrderedDrugDto;
import com.isa.supplier.repository.OrderRepository;
import com.isa.supplier.service.interfaces.IOrderService;
import com.isa.user.domain.PharmacyAdministrator;
import com.isa.user.service.implementation.PharmacyAdminService;
import com.isa.user.service.interfaces.IPharmacyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final IDrugService drugService;
    private final IPharmacyService pharmacyService;
    private final WarehouseRepository warehouseService;
    private final IPharmacyAdminService pharmacyAdminService;

    @Autowired
    public OrderService(OrderRepository orderRepository, IDrugService drugService, IPharmacyService pharmacyService, WarehouseRepository warehouseService, IPharmacyAdminService pharmacyAdminService) {
        this.orderRepository = orderRepository;
        this.drugService = drugService;
        this.pharmacyService = pharmacyService;
        this.warehouseService = warehouseService;
        this.pharmacyAdminService = pharmacyAdminService;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order save(CreateOrderDto createOrderDto, Long pharmacyId, Long pharmacyAdmin) {
        List<OrderedDrug> orderedDrugs = getOrderedDrugs(createOrderDto);
        Pharmacy pharmacy = pharmacyService.getById(pharmacyId);
        PharmacyAdministrator pharmacyAdministrator = pharmacyAdminService.findById(pharmacyAdmin);

        Order newOrder = new Order();
        newOrder.setCreationDate(LocalDate.now());
        newOrder.setDueDate(createOrderDto.getDueDate());
        newOrder.setOrderedDrug(orderedDrugs);
        newOrder.setStatus(OrderStatus.PENDING);
        newOrder.setPharmacy(pharmacy);
        newOrder.setPharmacyAdministrator(pharmacyAdministrator);
        addDrugToWarehouse(pharmacyId, orderedDrugs);
        return orderRepository.save(newOrder);
    }

    @Override
    public List<Order> findAllByPharmacyId(Long pharmacyId) {
        return orderRepository.findAllByPharmacyId(pharmacyId);
    }

    @Override
    public void addDrugToWarehouse(Long pharmacyId, List<OrderedDrug> orderedDrugs) {
        Warehouse warehouse = warehouseService.findByPharmacyId(pharmacyId);
        List<Item> items = warehouse.getItems();
        addItems(orderedDrugs, items);

        warehouseService.save(warehouse);
    }

    @Override
    public List<Order> filterByStatus(Long pharmacyId, OrderStatus orderStatus) {
        return orderRepository.filterByStatus(pharmacyId, orderStatus);
    }

    private void addItems(List<OrderedDrug> orderedDrugs, List<Item> items) {
        for(OrderedDrug it : orderedDrugs) {
            if (drugExists(it.getDrug(), items)) continue;

            Item newItem = new Item(0, it.getDrug());
            items.add(newItem);
        }
    }

    private boolean drugExists(Drug drug, List<Item> items) {
        return items.stream().map(Item::getDrug).anyMatch(drug::equals);
    }


    private List<OrderedDrug> getOrderedDrugs(CreateOrderDto createOrderDto) {
        List<CreateOrderedDrugDto> orderDrugDtos = createOrderDto.getOrderedDrugs();
        List<OrderedDrug> orderedDrugs = new ArrayList<>();
        for(CreateOrderedDrugDto it : orderDrugDtos) {
            Drug drug = drugService.findById(it.getDrugId());
            OrderedDrug orderedDrug = new OrderedDrug(it.getQuantity(), drug);
            orderedDrugs.add(orderedDrug);
        }
        return orderedDrugs;
    }


}
