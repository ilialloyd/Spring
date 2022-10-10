package com.company.jackson.json.demo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @JsonIgnoreProperties - bu o demekdir ki əgər
// JSON faylında bizim qeyd etmədiyimiz propertiyləpr varsa Exception atmayacaq və iqnor edəcək
@JsonIgnoreProperties(ignoreUnknown = true)

@Getter
@Setter
@NoArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private boolean active;
    private String[] languages;
    //this is for nested address object
    private Address address;


}
