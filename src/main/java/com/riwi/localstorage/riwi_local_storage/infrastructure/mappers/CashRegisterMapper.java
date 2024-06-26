package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CashRegisterRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CashRegisterResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.CashRegister;

@Mapper(componentModel = "spring")
public interface CashRegisterMapper {
    
    CashRegisterResponse cashRegisterToCashRegisterResponsesponse(CashRegister cashRegister);


    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "cash", ignore = true)
    })
    CashRegister cashRegisterRequestToCashRegister(CashRegisterRequest request);
}
