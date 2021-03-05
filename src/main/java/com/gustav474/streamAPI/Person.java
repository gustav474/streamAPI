package com.gustav474.streamAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@ToString
public class Person {
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
}
