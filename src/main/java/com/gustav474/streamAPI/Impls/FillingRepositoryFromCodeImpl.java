package com.gustav474.streamAPI.Impls;

import com.gustav474.streamAPI.Interfaces.FillingRepository;
import com.gustav474.streamAPI.Person;
import com.gustav474.streamAPI.Repository;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class FillingRepositoryFromCodeImpl implements FillingRepository<Repository, Person> {
    private Repository<Person> repository;

    @Override
    public Repository<Person> filling(List<Person> c) {
        repository.setList(c);
        return repository;
    }
}
