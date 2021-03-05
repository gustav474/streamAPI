package com.gustav474.streamAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;

    @Override
    public String toString() {
        return "com.gustav474.streamAPI.Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

}
