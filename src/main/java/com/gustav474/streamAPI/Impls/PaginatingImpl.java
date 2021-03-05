package com.gustav474.streamAPI.Impls;

import com.gustav474.streamAPI.Interfaces.Paginating;
import com.gustav474.streamAPI.Person;
import com.gustav474.streamAPI.Repository;

import java.util.ArrayList;

public class PaginatingImpl implements Paginating<Repository> {
    private Repository<Person> repository;

    public PaginatingImpl(Repository<Person> repository) {
        this.repository = repository;
    }

    @Override
    public Repository<Person> pagination(int itemsByPage, int pageNumber) {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        int toIndex = itemsByPage * pageNumber;
        if (toIndex > repository.getModifiedList().size() - 1) toIndex = repository.getModifiedList().size();
        int fromIndex = itemsByPage * (pageNumber - 1);
        repository.setModifiedList(repository.getModifiedList().subList(fromIndex, toIndex));
        return repository;
    }
}
