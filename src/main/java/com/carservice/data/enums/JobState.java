package com.carservice.data.enums;

import lombok.Getter;

@Getter
public enum JobState {
    COMPLETED("Completed"),
    IN_PROGRESS("In Progress"),
    PENDING("Pending");

    private final String stateName;

    JobState(String stateName) {
        this.stateName = stateName;
    }
}
