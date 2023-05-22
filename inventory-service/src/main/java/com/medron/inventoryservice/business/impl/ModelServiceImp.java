package com.medron.inventoryservice.business.impl;

import com.medron.commonpackage.kafka.event.inventory.ModelDeletedEvent;
import com.medron.commonpackage.kafka.producer.KafkaProducer;
import com.medron.inventoryservice.business.ModelService;
import com.medron.inventoryservice.business.dto.abstracts.ModelRequest;
import com.medron.inventoryservice.business.dto.request.create.ModelCreateRequest;
import com.medron.inventoryservice.business.dto.request.update.ModelUpdateRequest;
import com.medron.inventoryservice.business.dto.response.get.ModelGetResponse;
import com.medron.inventoryservice.business.dto.response.getall.ModelGetAllResponse;
import com.medron.inventoryservice.business.rule.ModelBusinessRule;
import com.medron.inventoryservice.entity.Model;
import com.medron.inventoryservice.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ModelServiceImp implements ModelService {
    private final ModelRepository repository;
    private final ModelBusinessRule rules;
    private final ModelMapper mapper;
    private final KafkaProducer producer;

    Model requestToEntity(ModelRequest request){
        return mapper.map(request,Model.class);
    }
    ModelGetResponse entityToGetResponse(Model model){
        return mapper.map(model,ModelGetResponse.class);
    }
    ModelGetAllResponse entityToGetAllResponse(Model model){
        return mapper.map(model,ModelGetAllResponse.class);
    }


    @Override
    public void add(ModelCreateRequest request) {
        rules.checkNameExist(request.getName());
        Model model = requestToEntity(request);
        repository.save(model);
    }

    @Override
    public List<ModelGetAllResponse> getAll() {
        return repository.findAll().stream().map(this::entityToGetAllResponse).toList();
    }

    @Override
    public ModelGetResponse get(UUID id) {
        rules.checkEntityExist(id);
        return entityToGetResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public void update(UUID id, ModelUpdateRequest request) {
        rules.checkEntityExist(id);
        Model model = requestToEntity(request);
        model.setId(id);
        repository.save(model);

    }

    @Override
    public void delete(UUID id) {
        rules.checkEntityExist(id);
        repository.deleteById(id);
        sendKafkaModelDeletedEvent(id);
    }
    public void sendKafkaModelDeletedEvent(UUID modelId){
        producer.send(new ModelDeletedEvent(modelId),"topic-model-delete");
    }
}
