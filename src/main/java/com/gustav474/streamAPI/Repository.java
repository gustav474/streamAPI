package com.gustav474.streamAPI;

import com.gustav474.streamAPI.Interfaces.FillingRepository;
import com.gustav474.streamAPI.Interfaces.Filtering;
import com.gustav474.streamAPI.Interfaces.Paginating;
import com.gustav474.streamAPI.Interfaces.Sorting;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Repository<T extends Person> {
    private Filtering filter;
    private Sorting sorter;
    private Paginating paginator;
    private FillingRepository filler;

    private List<T> list;
    private List<T> modifiedList = new ArrayList<>();

    public void setList(List<T> list) {
        this.list = Collections.unmodifiableList(list);
    }
}
