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
}
