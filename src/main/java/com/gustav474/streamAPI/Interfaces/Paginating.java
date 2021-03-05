package com.gustav474.streamAPI.Interfaces;

import com.gustav474.streamAPI.Repository;

public interface Paginating<T extends Repository> {
    public T pagination(int itemsByPage, int pageNumber);
}
