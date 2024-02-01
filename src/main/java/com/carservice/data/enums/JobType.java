package com.carservice.data.enums;

import lombok.Getter;

@Getter
public enum JobType {
    BRAKE_REPAIR("Brake Repair"),
    DIAGNOSTICS("Diagnostics"),
    ENGINE_DIAGNOSTICS("Engine Diagnostics"),
    FILTER_CHANGE("Filter Change"),
    OIL_CHANGE("Oil Change"),
    PAINT_AND_BODY_WORK("Paint and Body Work"),
    TRANSMISSION_SERVICE("Transmission Service"),
    TUNE_UP("Tune-up"),
    WHEEL_ALIGNMENT("Wheel Alignment"),
    WINDSHIELD_REPLACEMENT("Windshield Replacement");

    private final String serviceName;

    JobType(String serviceName) {
        this.serviceName = serviceName;
    }
}
