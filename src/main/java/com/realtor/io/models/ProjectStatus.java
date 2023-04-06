package com.realtor.io.models;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public enum ProjectStatus {
    STARTED("Started"),
    IN_PROGRESS("In_Progress"),
    COMPLETED("Completed");

    private final String STATUS;
    ProjectStatus(String status) {
        this.STATUS = status;
    }
}
