package com.gustav474.streamAPI.Impls;

import com.gustav474.streamAPI.Gender;
import com.gustav474.streamAPI.Interfaces.Filtering;
import com.gustav474.streamAPI.Person;
import com.gustav474.streamAPI.Repository;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Data
public class FilteringImpl implements Filtering<Repository> {

    private Repository<Person> repository;

    public FilteringImpl(Repository<Person> repository) {
        this.repository = repository;
    }

    @Override
    public Repository<Person> filteringByDateOfBirthAfter(LocalDate dateOfBirth) {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        repository.setModifiedList(repository.getModifiedList()
                .stream()
                .filter(p -> p.getDateOfBirth().isAfter(dateOfBirth))
                .collect(Collectors.toList()));
        return repository;
    }

    @Override
    public Repository<Person> filteringByDateOfBirthBefore(LocalDate dateOfBirth) {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        repository.setModifiedList(repository.getModifiedList()
                .stream()
                .filter(p -> p.getDateOfBirth().isBefore(dateOfBirth))
                .collect(Collectors.toList()));
        return repository;
    }

    @Override
    public Repository<Person> filteringByDateOfBirthEqual(LocalDate dateOfBirth) {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        repository.setModifiedList(repository.getModifiedList()
                .stream()
                .filter(p -> p.getDateOfBirth().isEqual(dateOfBirth))
                .collect(Collectors.toList()));
        return repository;
    }

    @Override
    public Repository<Person> filteringByDateOfBirthEqualYear(int year) {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        repository.setModifiedList(repository.getModifiedList()
                .stream()
                .filter(p -> p.getDateOfBirth().getYear() == year)
                .collect(Collectors.toList()));
        return repository;
    }

    @Override
    public Repository<Person> filteringByDateOfBirthEqualMonth(int month) {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        repository.setModifiedList(repository.getModifiedList()
                .stream()
                .filter(p -> p.getDateOfBirth().getMonthValue() == month)
                .collect(Collectors.toList()));
        return repository;
    }

    @Override
    public Repository<Person> filteringByDateOfBirthEqualDay(int day) {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        repository.setModifiedList(repository.getModifiedList()
                .stream()
                .filter(p -> p.getDateOfBirth().getDayOfMonth() == day)
                .collect(Collectors.toList()));
        return repository;
    }

    @Override
    public Repository<Person> filteringByNameEqual(String name) {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        repository.setModifiedList(repository.getModifiedList()
                .stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList()));
        return repository;
    }

    @Override
    public Repository<Person> filteringByGender(Gender gender) {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        repository.setModifiedList(repository.getModifiedList()
                .stream()
                .filter(p -> p.getGender() == gender)
                .collect(Collectors.toList()));
        return repository;
    }
}
