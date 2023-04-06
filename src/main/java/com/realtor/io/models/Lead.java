package com.realtor.io.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Auditable;

import java.io.Serializable;
import java.time.Instant;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    public Project project;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "surname")
    public String surname;

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
