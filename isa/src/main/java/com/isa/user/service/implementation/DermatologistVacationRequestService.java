package com.isa.user.service.implementation;

import com.isa.helper.mail.dto.MailDto;
import com.isa.helper.mail.service.mailService.interfaces.IMailService;
import com.isa.user.domain.Dermatologist;
import com.isa.user.domain.DermatologistVacationRequest;
import com.isa.user.domain.enumeration.VacationRequestStatus;
import com.isa.user.exception.VacationRequestException;
import com.isa.user.repository.DermatologistVacationRequestRepository;
import com.isa.user.service.interfaces.IDermatologistVacationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DermatologistVacationRequestService implements IDermatologistVacationRequestService {

    private final DermatologistVacationRequestRepository dermatologistVacationRequestRepository;
    private final IMailService mailService;

    @Autowired
    public DermatologistVacationRequestService(DermatologistVacationRequestRepository dermatologistVacationRequestRepository, IMailService mailService) {
        this.dermatologistVacationRequestRepository = dermatologistVacationRequestRepository;
        this.mailService = mailService;
    }

    @Override
    public DermatologistVacationRequest process(Long id, VacationRequestStatus status, String message) {

        DermatologistVacationRequest vacationRequest = dermatologistVacationRequestRepository.getDermatologistVacationRequestById(id);
        if(vacationRequest == null) return null;

        if(isProcessed(vacationRequest)) throw new VacationRequestException("Vacation request is already processed");

        vacationRequest.setStatus(status);
        vacationRequest.setAdminResponse(message);

        notifyDermatologist(vacationRequest);
        return dermatologistVacationRequestRepository.save(vacationRequest);
    }

    @Override
    public List<DermatologistVacationRequest> getDermatologistVacationRequestsByPharmacyIdAndStatus(Long pharmacyId, VacationRequestStatus status) {
        return dermatologistVacationRequestRepository.getDermatologistVacationRequestsByPharmacyIdAndStatus(pharmacyId, status);
    }

    @Override
    public List<DermatologistVacationRequest> getDermatologistVacationRequestsByPharmacyId(Long pharmacyId) {
        return dermatologistVacationRequestRepository.getDermatologistVacationRequestsByPharmacyId(pharmacyId);
    }

    @Override
    public DermatologistVacationRequest getDermatologistVacationRequestById(Long id) {
        return dermatologistVacationRequestRepository.getDermatologistVacationRequestById(id);
    }

    @Override
    public List<DermatologistVacationRequest> filter(Long pharmacyId, String name, String surname, VacationRequestStatus status) {
        name = name.toLowerCase().trim();
        if(Objects.equals(name, "")) {
            name = "%";
        }
        surname = surname.toLowerCase().trim();
        if(Objects.equals(name, "")) {
            name = "%";
        }

        List<DermatologistVacationRequest> requests = dermatologistVacationRequestRepository.search(pharmacyId, name, surname);
        return requests.stream().filter(vacationRequest -> vacationRequest.getStatus() == status).collect(Collectors.toList());
    }

    private boolean isProcessed(DermatologistVacationRequest vacationRequest) {
        return vacationRequest.getStatus() != VacationRequestStatus.CREATED;
    }

    private void notifyDermatologist(DermatologistVacationRequest vacationRequest) {
        MailDto mailDto = new MailDto();
        mailDto.setReceiver(vacationRequest.getDermatologist().getEmail());
        mailDto.setSubject("Vacation request response");
        mailDto.setText(createMessage(vacationRequest));

        mailService.sendMail(mailDto);
    }

    private String createMessage(DermatologistVacationRequest vacationRequest) {
        LocalDateTime start = vacationRequest.getVacationTime().getStart();
        LocalDateTime end = vacationRequest.getVacationTime().getEnd();

        String startString = formatDate(start);
        String endString = formatDate(end);
        String status = formatStatus(vacationRequest.getStatus());
        
        StringBuilder message = new StringBuilder("Your vacation request from " + startString + " to " + endString + " is " + status);
        if(vacationRequest.getStatus() == VacationRequestStatus.REJECTED)
            message.append("\nAdmin response: ").append(vacationRequest.getAdminResponse());


        return message.toString();

    }

    private String formatDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    private String formatStatus(VacationRequestStatus status) {
        if(status == VacationRequestStatus.CREATED) {
            return "created";
        } else if(status == VacationRequestStatus.ACCEPTED) {
            return "accepted";
        } else {
            return "rejected";
        }

    }

}
