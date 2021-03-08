package com.gustav474.streamAPI;

import com.gustav474.streamAPI.Exceptions.MoreThanTwoElementsException;
import com.gustav474.streamAPI.Interfaces.FillingRepository;
import com.gustav474.streamAPI.Interfaces.Filtering;
import com.gustav474.streamAPI.Interfaces.Paginating;
import com.gustav474.streamAPI.Interfaces.Sorting;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Repository<T extends Person> {
    private Filtering filter;
    private Sorting sorter;
    private Paginating paginator;
    private FillingRepository filler;

    private List<T> list = new ArrayList<>();
    private List<T> modifiedList = new ArrayList<>();

    //Custom setter for removing all null elements in list
    public void setList(List<T> list) throws MoreThanTwoElementsException {
        if (list.size() < 2) throw new MoreThanTwoElementsException("Repository must have minimum two elements");
        list.removeIf(Objects::isNull);
        this.list = list;
    }
}
