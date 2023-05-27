package com.medron.invoiceservice.business.service;

import com.medron.invoiceservice.business.dto.InvoiceGetAllResponse;
import com.medron.invoiceservice.business.dto.InvoiceGetResponse;
import com.medron.invoiceservice.entity.Invoice;
import java.util.List;

public interface InvoiceService {
    void add(Invoice invoice);
    InvoiceGetResponse get(String id);
    List<InvoiceGetAllResponse> getAll();
    void delete(String id);
}
