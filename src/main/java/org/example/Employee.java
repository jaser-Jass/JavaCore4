package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private Gender gender;
}
