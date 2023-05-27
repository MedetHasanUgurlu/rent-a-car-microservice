package com.medron.invoiceservice.api;

import com.medron.invoiceservice.business.dto.InvoiceGetAllResponse;
import com.medron.invoiceservice.business.dto.InvoiceGetResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface InvoiceController {
    ResponseEntity<List<InvoiceGetAllResponse>> getAll();
    ResponseEntity<InvoiceGetResponse> get(String id);
    ResponseEntity<Void> delete(String id);

}
