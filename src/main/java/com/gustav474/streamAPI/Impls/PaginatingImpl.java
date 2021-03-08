package com.gustav474.streamAPI.Impls;

import com.gustav474.streamAPI.Interfaces.Paginating;
import com.gustav474.streamAPI.Person;
import com.gustav474.streamAPI.Repository;
import java.util.ArrayList;

public class PaginatingImpl implements Paginating<Repository> {
    private Repository<Person> repository;
    private int toIndex;
    private int fromIndex;

    public PaginatingImpl(Repository<Person> repository) {
        this.repository = repository;
    }

    @Override
    public Repository<Person> pagination(int itemsByPage, int pageNumber) {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        toIndex = itemsByPage * pageNumber;
        fromIndex = itemsByPage * (pageNumber - 1);
        if (toIndex > repository.getModifiedList().size() - 1) toIndex = repository.getModifiedList().size();
        repository.setModifiedList(repository.getModifiedList().subList(fromIndex, toIndex));
        return repository;
    }
}
