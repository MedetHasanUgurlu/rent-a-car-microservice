package com.medron.rentalservice.business.service.imp;

import com.medron.commonpackage.kafka.event.rental.RentalCreateEvent;
import com.medron.commonpackage.kafka.producer.KafkaProducer;
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
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RentalServiceImp implements RentalService {
    private final RentalRepository repository;
    private final RentalBusinessRule rule;
    private final ModelMapper mapper;
    private final CarClient carClient;
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
        carClient.checkCarAvailable(request.getCarId());
        rental.setId(null);
        rental.setRentedAt(LocalDate.now());
        rental.setTotalPrice(calculateTotalPrice(request.getRentedForDays(), request.getDailyPrice()));
        repository.save(dtoToEntity(request));

    }

    @Override
    public void delete(UUID id) {
        rule.checkEntityExist(id);
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

    private double calculateTotalPrice(int days,double dailyPrice){
        return days*dailyPrice;
    }

    public void sendkafkaRentalCreated(RentalCreateEvent event){
        producer.send(event,"rental-create-event");
    }

}
