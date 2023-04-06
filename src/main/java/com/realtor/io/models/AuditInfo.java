package com.realtor.io.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Slf4j
@Builder
@ToString
@Embeddable
public class AuditInfo implements Serializable {

    public static final long serialVersionUID = 123456789L;

    @Column(name = "created_by")
    public String createdBy;

    @Column(name = "updated_by")
    public String updatedBy;

    @Column(name = "deleted_by")
    public String deletedBy;

    @Column(name = "created_on")
    public Instant createdOn;

    @Column(name = "updated_on")
    public Instant updatedOn;

    @Column(name = "deleted_on")
    public Instant deletedOn;
}
