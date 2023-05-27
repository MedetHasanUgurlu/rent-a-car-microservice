package com.medron.invoiceservice.business.rule;

import com.medron.commonpackage.exception.exceptions.BusinessException;
import com.medron.invoiceservice.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceBusinessRule {
    private final InvoiceRepository repository;
    public void checkEntityExist(String id){
        if(repository.findById(id).isEmpty()){
            throw new BusinessException("Invoice not found.");
        }
    }
}
