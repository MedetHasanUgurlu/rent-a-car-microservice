package com.medron.rentalservice.business.service;

import com.medron.commonpackage.exception.exceptions.BusinessException;
import com.medron.commonpackage.kafka.event.rental.RentalCreateEvent;
import com.medron.commonpackage.kafka.event.rental.RentalDeleteEvent;
import com.medron.commonpackage.kafka.event.rental.RentalReturnEvent;
import com.medron.commonpackage.kafka.producer.KafkaProducer;
import com.medron.commonpackage.utils.dto.PaymentRentalRequest;
import com.medron.rentalservice.api.client.CarClient;
import com.medron.rentalservice.business.dto.request.RentalCreateRequest;
import com.medron.rentalservice.business.dto.request.RentalRequest;
import com.medron.rentalservice.business.dto.request.RentalUpdateRequest;
import com.medron.rentalservice.business.dto.response.RentalGetAllResponse;
import com.medron.rentalservice.business.dto.response.RentalGetResponse;
import com.medron.rentalservice.business.rule.RentalBusinessRule;
import com.medron.rentalservice.business.service.RentalService;
import com.medron.rentalservice.entity.Rental;
import com.medron.rentalservice.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Slf4j
@Service
@RequiredArgsConstructor
public class RentalServiceImp implements RentalService {
    private final RentalRepository repository;
    private final RentalBusinessRule rule;
    private final ModelMapper mapper;
    private final KafkaProducer producer;


    public Rental dtoToEntity(RentalRequest request){
        return mapper.map(request,Rental.class);
    }
    public RentalGetResponse entityToGetResponse(Rental rental){
        return mapper.map(rental,RentalGetResponse.class);
    }
    public List<RentalGetAllResponse> entityToGetAllResponse(List<Rental> list){
        return list.stream().map(rental -> mapper.map(rental, RentalGetAllResponse.class)).toList();
    }


    @Override
    public void add(RentalCreateRequest request) {
        Rental rental = dtoToEntity(request);
        rule.checkCarAvailable(request.getCarId());



        PaymentRentalRequest rentalRequest = request.getPaymentRentalRequest();
        rentalRequest.setPrice(request.getDailyPrice()*request.getRentedForDays());


        rule.checkPayment(rentalRequest);
        rental.setId(null);
        rental.setRentedAt(LocalDate.now());
        rental.setTotalPrice(request.getDailyPrice()*request.getRentedForDays());
        repository.save(rental);
        sendKafkaRentalCreated(new RentalCreateEvent(request.getCarId()));

    }

    @Override
    public void delete(UUID id) {
        rule.checkEntityExist(id);
        sendKafkaRentalDeleted(new RentalDeleteEvent(repository.findById(id).orElseThrow().getCarId()));
        repository.deleteById(id);

    }

    @Override
    public void update(UUID id, RentalUpdateRequest request) {
        rule.checkEntityExist(id);
        Rental rental = dtoToEntity(request);
        rental.setId(id);
        repository.save(rental);

    }

    @Override
    public RentalGetResponse get(UUID id) {
        return entityToGetResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public List<RentalGetAllResponse> getAll() {
        return entityToGetAllResponse(repository.findAll());
    }

    @Override
    public void returnFromRented(UUID id) {
        rule.checkEntityExist(id);
        sendKafkaRentalReturned(new RentalReturnEvent(repository.findById(id).orElseThrow().getCarId()));
    }

    public void sendKafkaRentalCreated(RentalCreateEvent event){
        producer.send(event,"topic-rental-create");
    }
    public void sendKafkaRentalDeleted(RentalDeleteEvent event){
        producer.send(event,"topic-rental-delete");
    }
    public void sendKafkaRentalReturned(RentalReturnEvent event){
        producer.send(event,"topic-rental-return");
    }


    /*

    topic-rental-create
    topic-rental-return
    topic-rental-delete
     */

}
