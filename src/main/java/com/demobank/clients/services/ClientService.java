package com.demobank.clients.services;

import com.demobank.clients.dtos.ClientGetResponseDTO;
import com.demobank.clients.dtos.ClientResponseDTO;
import com.demobank.clients.dtos.Query;
import com.demobank.clients.entities.Client;
import com.demobank.clients.repositories.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private ClientRepository clientRepository;
    public ClientService(final ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientGetResponseDTO findAll(final int page,
                                        final int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<Client> clientsPage = clientRepository.findAll(pageable);
        ClientGetResponseDTO clientGetResponseDTO = new ClientGetResponseDTO();
        clientGetResponseDTO.setData(
                clientsPage.getContent().stream()
                        .map(this::mapToClientResponseDTO)
                        .toList()
        );
        clientGetResponseDTO.setQuery(new Query(page, limit));
        return clientGetResponseDTO;
    }

    private ClientResponseDTO mapToClientResponseDTO(final Client client) {
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();
        clientResponseDTO.setClientId(client.getClientId());
        clientResponseDTO.setFirstName(client.getFirstName());
        clientResponseDTO.setLastName(client.getLastName());
        clientResponseDTO.setBirthdate(client.getBirthdate());
        clientResponseDTO.setGender(client.getGender());
        clientResponseDTO.setAddress(client.getAddress());
        clientResponseDTO.setPhoneNumber(client.getPhoneNumber());
        clientResponseDTO.setStatus(client.getStatus());
        return clientResponseDTO;
    }
}
