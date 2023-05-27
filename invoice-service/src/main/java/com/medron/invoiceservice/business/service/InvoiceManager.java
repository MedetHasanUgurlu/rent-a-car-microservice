package com.medron.invoiceservice.business.service;

import com.medron.invoiceservice.business.dto.InvoiceGetAllResponse;
import com.medron.invoiceservice.business.dto.InvoiceGetResponse;
import com.medron.invoiceservice.business.rule.InvoiceBusinessRule;
import com.medron.invoiceservice.entity.Invoice;
import com.medron.invoiceservice.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvoiceManager implements InvoiceService {
    private final ModelMapper mapper;
    private final InvoiceRepository repository;
    private final InvoiceBusinessRule rule;



    @Override
    public void add(Invoice invoice) {
        invoice.setId(UUID.randomUUID().toString());
        repository.save(invoice);
    }

    @Override
    public InvoiceGetResponse get(String id) {
        rule.checkEntityExist(id);
        return mapper.map(repository.findById(id).get(),InvoiceGetResponse.class);
    }

    @Override
    public List<InvoiceGetAllResponse> getAll() {
        return repository.findAll().stream().map(invoice -> mapper.map(invoice,InvoiceGetAllResponse.class)).toList();
    }

    @Override
    public void delete(String id) {
        rule.checkEntityExist(id);
        repository.deleteById(id);
    }
}
