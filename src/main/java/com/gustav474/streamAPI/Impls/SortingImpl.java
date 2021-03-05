package com.gustav474.streamAPI.Impls;

import com.gustav474.streamAPI.Gender;
import com.gustav474.streamAPI.Interfaces.Sorting;
import com.gustav474.streamAPI.Person;
import com.gustav474.streamAPI.Repository;

import java.util.ArrayList;
import java.util.Comparator;

public class SortingImpl implements Sorting<Repository> {
    private Repository<Person> repository;

    public SortingImpl(Repository<Person> repository) {
        this.repository = repository;
    }

    //По имени
    //По убыванию
    private Comparator<Person> compareByNameDescending = (Person o1, Person o2) -> {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
    };

    //По возрастанию
    private Comparator<Person> compareByNameAscending = (Person o1, Person o2) -> {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName()) * (-1);
    };

    //По дате рождения
    //По убыванию
    private Comparator<Person> compareByDateOfBirthFromNewestToOldest = (Person o1, Person o2) -> {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth()) * (-1);
    };

    //По возростанию
    private Comparator<Person> compareByDateOfBirthFromOldestToNewest = (Person o1, Person o2) -> {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    };

    //По полу
    //Сначала MALE
    private Comparator<Person> compareByGenderMaleFemale = (Person o1, Person o2) -> {
        if (o1.getGender() == Gender.MALE && o2.getGender() == Gender.MALE) return 0;
        else if (o1.getGender() == Gender.MALE && o2.getGender() == Gender.FEMALE) return -1;
        return 1;
    };

    //Сначала FEMALE
    private Comparator<Person> compareByGenderFemaleMale = (Person o1, Person o2) -> {
        if (o1.getGender() == Gender.FEMALE && o2.getGender() == Gender.FEMALE) return 0;
        else if (o1.getGender() == Gender.FEMALE && o2.getGender() == Gender. MALE) return -1;
        return 1;
    };

    @Override
    public Repository<Person> sortingByNameDescending() {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        repository.getModifiedList().sort(compareByNameDescending);
        return repository;
    }

    @Override
    public Repository<Person> sortingByNameAscending() {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        repository.getModifiedList().sort(compareByNameAscending);
        return repository;
    }

    @Override
    public Repository<Person> sortingByDateOfBirthFromNewestToOldest() {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        repository.getModifiedList().sort(compareByDateOfBirthFromNewestToOldest);
        return repository;
    }

    @Override
    public Repository<Person> sortingByDateOfBirthFromOldestToNewest() {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        repository.getModifiedList().sort(compareByDateOfBirthFromOldestToNewest);
        return repository;
    }

    @Override
    public Repository<Person> sortingByGenderMaleFemale() {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        repository.getModifiedList().sort(compareByGenderMaleFemale);
        return repository;
    }

    @Override
    public Repository<Person> sortingByGenderFemaleMale() {
        if (repository.getModifiedList().size() == 0) repository.setModifiedList(new ArrayList<>(repository.getList()));
        repository.getModifiedList().sort(compareByGenderFemaleMale);
        return repository;
    }
}