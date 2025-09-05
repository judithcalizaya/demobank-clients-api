package com.demobank.clients.controllers;

import com.demobank.clients.dtos.ClientGetResponseDTO;
import com.demobank.clients.dtos.ClientResponseDTO;
import com.demobank.clients.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private ClientService clientService;

    public ClientController(final ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ClientGetResponseDTO findAll(
            @RequestParam(required=false, defaultValue="0") int page,
            @RequestParam(required=false, defaultValue="10") int limit
    ) {
        return this.clientService.findAll(page, limit);
    }

    @GetMapping("/{id}")
    public ClientResponseDTO getClient(@PathVariable("id") String id) {
        return this.clientService.findById(id);
    }

    @PostMapping
    public ClientResponseDTO create(@Valid @RequestBody ClientResponseDTO clientResponseDTO) {
        return this.clientService.create(clientResponseDTO);
    }

    @PatchMapping("/{id}")
    public ClientResponseDTO update(
            @PathVariable("id") String id,
            @RequestBody ClientResponseDTO clientResponseDTO) {
        return this.clientService.update(id, clientResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ClientResponseDTO delete(
            @PathVariable("id") String id) {
        return this.clientService.delete(id);
    }
}
