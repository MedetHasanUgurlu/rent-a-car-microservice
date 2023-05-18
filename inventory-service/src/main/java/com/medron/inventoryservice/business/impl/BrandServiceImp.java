package com.medron.inventoryservice.business.impl;

import com.medron.commonpackage.kafka.event.inventory.BrandDeletedEvent;
import com.medron.inventoryservice.business.BrandService;
import com.medron.inventoryservice.business.dto.abstracts.BrandRequest;
import com.medron.inventoryservice.business.dto.request.create.BrandCreateRequest;
import com.medron.inventoryservice.business.dto.request.update.BrandUpdateRequest;
import com.medron.inventoryservice.business.dto.response.get.BrandGetResponse;
import com.medron.inventoryservice.business.dto.response.getall.BrandGetAllResponse;
import com.medron.inventoryservice.business.rule.BrandBusinessRule;
import com.medron.inventoryservice.entity.Brand;
import com.medron.inventoryservice.kafka.InventoryProducer;
import com.medron.inventoryservice.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class BrandServiceImp implements BrandService {
    private final BrandRepository repository;
    private final BrandBusinessRule rules;
    private final ModelMapper modelMapper;
    private final InventoryProducer producer;

    Brand requestToEntity(BrandRequest request){
        return modelMapper.map(request,Brand.class);
    }
    BrandGetResponse entityToGetResponse(Brand brand){
        return modelMapper.map(brand,BrandGetResponse.class);
    }
    BrandGetAllResponse entityToGetAllResponse(Brand brand){
        return modelMapper.map(brand,BrandGetAllResponse.class);
    }

    @Override
    public void add(BrandCreateRequest request) {
        rules.checkNameExist(request.getName());
        Brand brand = requestToEntity(request);
        repository.save(brand);
    }

    @Override
    public List<BrandGetAllResponse> getAll() {
        return repository.findAll().stream().map(this::entityToGetAllResponse).toList();
    }

    @Override
    public BrandGetResponse get(UUID id) {
        rules.checkEntityExist(id);
        return entityToGetResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public void update(UUID id,BrandUpdateRequest request) {
        rules.checkEntityExist(id);
        rules.checkNameExist(request.getName());
        Brand brand = requestToEntity(request);
        brand.setId(id);
        repository.save(brand);
    }

    @Override
    public void delete(UUID id) {
        rules.checkEntityExist(id);
        repository.deleteById(id);
        sendKafkaBrandDeleted(id);
    }


    public void sendKafkaBrandDeleted(UUID brandId){
        log.info("Brand:Id"+brandId.toString());
        producer.sendMessage(BrandDeletedEvent.builder().brandId(brandId).build(),"topic-brand-delete");
    }
}
