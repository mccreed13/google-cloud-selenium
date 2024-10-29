package com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums;

public enum GPUModels {
    TESLA_P100("NVIDIA Tesla P100"), TESLA_P4("NVIDIA Tesla P4"), TESLA_V100("NVIDIA V100"), TESLA_T4("NVIDIA Tesla T4");

    public final String value;

    GPUModels(String value) {
        this.value = value;
    }

    public static GPUModels get(String value) {
        for (GPUModels n : GPUModels.values()) {
            if (n.value.equals(value)) {
                return n;
            }
        }
        return null;
    }
}
