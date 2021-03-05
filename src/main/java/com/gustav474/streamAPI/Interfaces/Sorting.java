package com.gustav474.streamAPI.Interfaces;

import com.gustav474.streamAPI.Repository;

public interface Sorting<T extends Repository> {
    public T sortingByNameDescending();

    public T sortingByNameAscending();

    public T sortingByDateOfBirthFromNewestToOldest();

    public T sortingByDateOfBirthFromOldestToNewest();

    public T sortingByGenderMaleFemale();

    public T sortingByGenderFemaleMale();
}
