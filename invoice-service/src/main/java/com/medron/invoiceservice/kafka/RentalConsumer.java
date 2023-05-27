package com.medron.invoiceservice.kafka;

import com.medron.commonpackage.kafka.event.invoice.InvoiceRentalCreateEvent;
import com.medron.invoiceservice.business.service.InvoiceService;
import com.medron.invoiceservice.entity.Invoice;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalConsumer {
    private final InvoiceService service;
    private final ModelMapper mapper;

    @KafkaListener(topics = "topic-rental-invoice-create",groupId = "gp-rental-invoice-create")
    public void consume(InvoiceRentalCreateEvent event){
        service.add(mapper.map(event, Invoice.class));
    }

}
