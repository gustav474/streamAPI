package com.gustav474.streamAPI.Interfaces;

import com.gustav474.streamAPI.Person;
import com.gustav474.streamAPI.Repository;
import java.util.List;

public interface FillingRepository<T extends Repository, E extends Person> {
    public T filling (List<E> c);
}
