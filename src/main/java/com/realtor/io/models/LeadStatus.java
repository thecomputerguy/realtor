package com.realtor.io.models;

public enum LeadStatus {
    REGISTERED_IN_SYSTEM("Registered in System"),
    CONTACTED("Contacted"),
    LEAD_REJECTED("Lead_Rejected"),
    AGENT_REJECTED("Agent_Rejected"),
    WARMED_UP("Warmed_Up"),
    Finalized("Finalized");
    private final String STATUS;

    LeadStatus(String status) {
        this.STATUS = status;
    }
}
