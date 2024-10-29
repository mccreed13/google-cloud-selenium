package com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums;

public enum LocalSSD {
    ZERO("0"), ONEx375GB("1x375 GB"), TWOx375GB("2x375 GB"), THREEx375GB("3x375 GB"), FOURx375GB("4x375 GB"), FIVEx375GB("5x375 GB"), SIXx375GB("6x375 GB"),
    SEVENx375GB("7x375 GB"), EIGHTx375GB("8x375 GB"), SIXTEENx375GB("16x375 GB"), TWENTY_FOURx375GB("24x375 GB");

    public final String value;

    LocalSSD(String value) {
        this.value = value;
    }

    public static LocalSSD get(String value) {
        for (LocalSSD n : LocalSSD.values()) {
            if (n.value.equals(value)) {
                return n;
            }
        }
        return null;
    }
}
