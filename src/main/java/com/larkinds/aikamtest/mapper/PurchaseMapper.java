package com.larkinds.aikamtest.mapper;

import com.larkinds.aikamtest.dto.model.PurchaseDto;
import com.larkinds.aikamtest.model.Purchase;
import com.larkinds.aikamtest.repository.PurchaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper extends AbstractMapper<Purchase, PurchaseDto> {
    private ModelMapper mapper;
    private PurchaseRepository repository;

    @Autowired
    public PurchaseMapper(ModelMapper mapper, PurchaseRepository repository) {
        super(Purchase.class, PurchaseDto.class);
    }
}
