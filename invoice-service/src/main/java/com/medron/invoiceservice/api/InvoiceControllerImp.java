package com.medron.invoiceservice.api;

import com.medron.invoiceservice.business.dto.InvoiceGetAllResponse;
import com.medron.invoiceservice.business.dto.InvoiceGetResponse;
import com.medron.invoiceservice.business.service.InvoiceService;
import com.medron.invoiceservice.entity.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invoice")
public class InvoiceControllerImp implements InvoiceController{

    private final InvoiceService service;
    @PostMapping("/test")
    public void addTest(){
        service.add(new Invoice());
    }


    @Override
    @GetMapping
    public ResponseEntity<List<InvoiceGetAllResponse>> getAll() {
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceGetResponse> get(@PathVariable String id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
