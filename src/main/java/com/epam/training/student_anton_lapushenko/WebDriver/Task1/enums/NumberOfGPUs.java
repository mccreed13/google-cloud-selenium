package com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums;

public enum NumberOfGPUs {
    ONE(1), TWO(2), FOUR(4), EIGHT(8);

    public final int value;

    NumberOfGPUs(int value) {
        this.value = value;
    }

    public static NumberOfGPUs get(int value) {
        for (NumberOfGPUs n : NumberOfGPUs.values()) {
            if (n.value == value) {
                return n;
            }
        }
        return null;
    }
}
