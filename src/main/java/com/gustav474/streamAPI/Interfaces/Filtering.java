package com.gustav474.streamAPI.Interfaces;

import com.gustav474.streamAPI.Gender;
import com.gustav474.streamAPI.Repository;

import java.time.LocalDate;

public interface Filtering<T extends Repository> {
    public T filteringByDateOfBirthAfter(LocalDate dateOfBirth);

    public T filteringByDateOfBirthBefore(LocalDate dateOfBirth);

    public T filteringByDateOfBirthEqual(LocalDate dateOfBirth);

    public T filteringByDateOfBirthEqualYear(int year);

    public T filteringByDateOfBirthEqualMonth(int month);

    public T filteringByDateOfBirthEqualDay(int day);

    public T filteringByNameEqual(String name);

    public T filteringByGender(Gender gender);
}
