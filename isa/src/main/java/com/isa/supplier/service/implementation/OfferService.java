package com.isa.supplier.service.implementation;

import com.isa.helper.mail.dto.MailDto;
import com.isa.helper.mail.service.mailService.interfaces.IMailService;
import com.isa.supplier.domain.Offer;
import com.isa.supplier.domain.Order;
import com.isa.supplier.domain.enumeration.OfferStatus;
import com.isa.supplier.dto.CreateOfferDto;
import com.isa.supplier.exception.AdminException;
import com.isa.supplier.exception.OfferNotFoundException;
import com.isa.supplier.exception.OrderNotFoundException;
import com.isa.supplier.repository.OfferRepository;
import com.isa.supplier.repository.OrderRepository;
import com.isa.supplier.service.interfaces.IOfferService;
import com.isa.user.domain.Supplier;
import com.isa.user.service.interfaces.ISupplierService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OfferService implements IOfferService {

    private final OfferRepository offerRepository;
    private final OrderRepository orderRepository;
    private final IMailService mailService;
    private final ISupplierService supplierService;

    @Autowired
    public OfferService(OfferRepository offerRepository, OrderRepository orderRepository, IMailService mailService, ISupplierService supplierService) {
        this.offerRepository = offerRepository;
        this.orderRepository = orderRepository;
        this.mailService = mailService;
        this.supplierService = supplierService;
    }
    @Override
    public List<Offer> findAllByOrderId(Long orderId) {
        return offerRepository.findAllByOrderId(orderId);
    }

    @Override
    public Offer createOffer(CreateOfferDto dto) throws OrderNotFoundException{
        Order order = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

        Supplier supplier = supplierService.findById(dto.getSupplierId());

        Offer offer = new Offer();
        offer.setStatus(OfferStatus.PENDING);
        offer.setDate(LocalDateTime.now());
        offer.setDueDate(dto.getDueDate());
        offer.setPrice(dto.getPrice());
        offer.setOrder(order);
        offer.setSupplier(supplier);
        return offerRepository.save(offer);
    }

    @Override
    public void acceptOffer(Long pharmacyAdminId, Long offerId, Long orderId) {
        isCreatedBy(pharmacyAdminId, orderId);

        List<Offer> offers = offerRepository.findAllByOrderIdWithSupplier(orderId);
        offers.forEach(o -> o.acceptOffer(offerId, pharmacyAdminId));

        offerRepository.saveAll(offers);
        notifySuppliers(offers);
    }

    private void isCreatedBy(Long pharmacyAdminId, Long orderId)  throws AdminException {
        Order order = orderRepository.findByIdWithPharmacyAdministrator(orderId);
        if(order == null) throw new AdminException("You can not accept this offer");
        if(!order.getPharmacyAdministrator().getId().equals(pharmacyAdminId))
            throw new AdminException("You can not accept this offer");
    }

    @Async
    public void notifySuppliers(List<Offer> offers) {
        offers.forEach(this::notifySupplier);
    }

    public void notifySupplier(Offer offer) {
        String message = constructMessage(offer);
        MailDto dto = new MailDto(offer.getSupplier().getEmail(), "Offer updated", message);
        mailService.sendMail(dto);
    }

    @NotNull
    private String constructMessage(Offer offer) {
        String message = null;
        if(offer.getStatus() == OfferStatus.ACCEPTED) {
            message = "Your offer is accepted";
        }
        else {
            message = "Your offer is rejected";
        }
        return message;
    }
}
