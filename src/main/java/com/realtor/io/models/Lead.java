package com.realtor.io.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
@Slf4j
@Entity
@Table(name = "leads")
public class Lead implements Serializable {

    public static final long serialVersionUID = 12345622789L;

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    public Project project;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "surname")
    public String middleName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "email")
    public String email;

    @Column(name = "phone")
    public String phone;

    @Column(name = "status")
    @Enumerated
    public LeadStatus status;

    @Column(name = "deleted")
    public Boolean deleted;

    @Embedded
    public AuditInfo auditInfo;
}
