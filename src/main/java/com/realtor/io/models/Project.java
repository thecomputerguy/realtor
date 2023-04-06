package com.realtor.io.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
@Slf4j
@Entity
@Table(name = "projects")
public class Project implements Serializable {

    public static final long serialVersionUID = 12345336789L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "hosted")
    public String hosted;

    @Column(name = "image_urls")
    public String imageUrls;

    @Column(name = "status")
    @Enumerated
    public ProjectStatus status;

    @Column(name = "deleted")
    public Boolean deleted;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public Collection<Lead> leads;

    @Embedded
    public AuditInfo auditInfo;
}
