package org.example.dto;

public record Address(String street,
                      String suite,
                      String city,
                      String zipcode,
                      Geo geo) {
}
