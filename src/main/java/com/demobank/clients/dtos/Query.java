package com.demobank.clients.dtos;

public class Query {
    public Query(final int page, final int limit) {
        this.page = page;
        this.limit = limit;
    }

    private int page;
    private int limit;

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
}
