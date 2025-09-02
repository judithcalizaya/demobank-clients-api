package com.demobank.clients.dtos;

import java.util.List;

public class ClientGetResponseDTO {
    private Query query;
    private List<ClientResponseDTO> data;

    public Query getQuery() {
        return query;
    }
    public void setQuery(Query query) {
        this.query = query;
    }

    public List<ClientResponseDTO> getData() {
        return data;
    }
    public void setData(List<ClientResponseDTO> data) {
        this.data = data;
    }

}
