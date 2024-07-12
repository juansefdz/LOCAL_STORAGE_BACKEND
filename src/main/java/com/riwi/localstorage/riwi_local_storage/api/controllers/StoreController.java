package com.riwi.localstorage.riwi_local_storage.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.StoreRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.StoreResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IStoreService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "stores")
@AllArgsConstructor
public class StoreController {

    @Autowired
    private final IStoreService service;

    /*----------------------
     * GET ALL ROLES
     * ---------------------
     */

    @GetMapping
    public ResponseEntity<Page<StoreResponse>> getAll(@PageableDefault(page = 0, size = 10, sort = "status") Pageable pageable) {
        Page<StoreResponse> responses = this.service.getAll(pageable);
        return ResponseEntity.ok(responses);
    }

     /*--------------------
     * GET BY ID
     * -------------------
     */

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<StoreResponse>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    /*--------------------
     * CREATE ROLE
     * -------------------
     */
        @Operation(summary = "creates a new store", description = "create a new store by entering the required data")
        @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
        })
        @PostMapping
        public ResponseEntity<StoreResponse>create(
            @Validated @RequestBody StoreRequest request
        ){
            return ResponseEntity.ok(this.service.create(request));
        }

    /*----------------------
     * UPDATE ROLE
     * ---------------------
     */

     //insert here your code

    /*----------------------
     * DELETE ROLE (DISABLE ROLE - SOFT DELETE)
     * ---------------------
     */

     //insert here your code
    
}
