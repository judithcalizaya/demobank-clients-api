package com.demobank.clients.services;

import com.demobank.clients.dtos.ClientGetResponseDTO;
import com.demobank.clients.dtos.ClientResponseDTO;
import com.demobank.clients.dtos.Query;
import com.demobank.clients.entities.Client;
import com.demobank.clients.repositories.ClientRepository;
import com.demobank.clients.services.exceptions.ClientNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
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

    public ClientResponseDTO findById(final String clientId) {
        Client client = clientRepository.findByClientId(clientId);
        if (client == null) {
            throw new ClientNotFoundException(clientId);
        }
        return mapToClientResponseDTO(client);
    }

    public ClientResponseDTO create(final ClientResponseDTO clientResponseDTO) {
        Client client = clientRepository.save(mapToClient(clientResponseDTO));
        return mapToClientResponseDTO(client);
    }

    public ClientResponseDTO update(final String clientId,
                                    final ClientResponseDTO clientResponseDTO) {
        Client receivedClient = clientRepository.findByClientId(clientId);
        if (receivedClient == null) {
            throw new ClientNotFoundException(clientId);
        }
        receivedClient.setPersonId(receivedClient.getPersonId());
        receivedClient.setClientId(receivedClient.getClientId());
        Client client = clientRepository.save(mapToClient(clientResponseDTO));
        return mapToClientResponseDTO(client);
    }

    public ClientResponseDTO delete(final String clientId) {
        Client receivedClient = clientRepository.findByClientId(clientId);
        if (receivedClient == null) {
            throw new ClientNotFoundException(clientId);
        }
        receivedClient.setPersonId(receivedClient.getPersonId());
        receivedClient.setClientId(receivedClient.getClientId());
        clientRepository.delete(receivedClient);
        return mapToClientResponseDTO(receivedClient);
    }

    private ClientResponseDTO mapToClientResponseDTO(final Client client) {
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();
        clientResponseDTO.setFirstName(client.getFirstName());
        clientResponseDTO.setLastName(client.getLastName());
        clientResponseDTO.setNationalId(client.getNationalId());
        clientResponseDTO.setBirthdate(client.getBirthdate());
        clientResponseDTO.setGender(client.getGender());
        clientResponseDTO.setAddress(client.getAddress());
        clientResponseDTO.setPhoneNumber(client.getPhoneNumber());
        clientResponseDTO.setClientId(client.getClientId());
        clientResponseDTO.setPassword(client.getPassword());
        clientResponseDTO.setStatus(client.getStatus());
        return clientResponseDTO;
    }

    private Client mapToClient(final ClientResponseDTO clientResponseDTO) {
        Client client = new Client();
        client.setFirstName(clientResponseDTO.getFirstName());
        client.setLastName(clientResponseDTO.getLastName());
        client.setNationalId(clientResponseDTO.getNationalId());
        client.setBirthdate(clientResponseDTO.getBirthdate());
        client.setGender(clientResponseDTO.getGender());
        client.setAddress(clientResponseDTO.getAddress());
        client.setPhoneNumber(clientResponseDTO.getPhoneNumber());
        client.setClientId(clientResponseDTO.getClientId());
        client.setPassword(clientResponseDTO.getPassword());
        client.setStatus(clientResponseDTO.isStatus());
        return client;
    }
}
