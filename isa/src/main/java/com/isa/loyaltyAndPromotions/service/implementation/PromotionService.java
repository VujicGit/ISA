package com.isa.loyaltyAndPromotions.service.implementation;

import com.isa.appointment.domain.TimePeriod;
import com.isa.helper.mail.dto.MailDto;
import com.isa.helper.mail.service.mailService.implementation.MailService;
import com.isa.helper.mail.service.mailService.interfaces.IMailService;
import com.isa.loyaltyAndPromotions.domain.Promotion;
import com.isa.loyaltyAndPromotions.domain.Subscription;
import com.isa.loyaltyAndPromotions.dto.PromotionDto;
import com.isa.loyaltyAndPromotions.repository.PromotionRepository;
import com.isa.loyaltyAndPromotions.service.interfaces.IPromotionService;
import com.isa.loyaltyAndPromotions.service.interfaces.ISubscriptionService;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import com.isa.user.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class PromotionService implements IPromotionService {

    private final String subject = "pharmacy have new promotion ";

    private final PromotionRepository promotionRepository;
    private final IPharmacyService pharmacyService;
    private final ISubscriptionService subscriptionService;
    private final IMailService mailService;

    @Autowired
    public PromotionService(PromotionRepository promotionRepository, IPharmacyService pharmacyService, ISubscriptionService subscriptionService, IMailService mailService) {
        this.promotionRepository = promotionRepository;
        this.pharmacyService = pharmacyService;
        this.mailService = mailService;
        this.subscriptionService = subscriptionService;
    }
    @Override
    public Promotion create(Long pharmacyId, PromotionDto promotion) {
        Pharmacy pharmacy = pharmacyService.getById(pharmacyId);
        if(pharmacy == null) return null;

        TimePeriod timePeriod = new TimePeriod(promotion.getStart(), promotion.getEnd());
        Promotion newPromotion = new Promotion(promotion.getDescription(), timePeriod, pharmacy);

        sendMails(pharmacy, newPromotion);


        return promotionRepository.save(newPromotion);
    }

    @Override
    public List<Promotion> findAllByPharmacyId(Long pharmacyId) {
        return promotionRepository.findAllByPharmacyId(pharmacyId);
    }

    private void sendMails(Pharmacy pharmacy, Promotion promotion) {

        Subscription subscription = subscriptionService.getSubscriptionByPharmacyIdWithPatients(pharmacy.getId());

        List<Patient> users = subscription.getPatient();

        for(Patient it : users) {
            String subject = pharmacy.getDescription() + this.subject;
            MailDto mailDto = new MailDto(it.getEmail(), subject, promotion.getDescription());
            mailService.sendMail(mailDto);
        }
    }
}
