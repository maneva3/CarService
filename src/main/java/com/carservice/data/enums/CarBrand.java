package com.carservice.data.enums;

import lombok.Getter;

@Getter
public enum CarBrand {
    AUDI("Audi"),
    BMW("BMW"),
    CHEVROLET("Chevrolet"),
    FORD("Ford"),
    HONDA("Honda"),
    HYUNDAI("Hyundai"),
    MERCEDES_BENZ("Mercedes-Benz"),
    NISSAN("Nissan"),
    TOYOTA("Toyota"),
    VOLKSWAGEN("Volkswagen");

    private final String brandName;

    CarBrand(String brandName) {
        this.brandName = brandName;
    }
}
