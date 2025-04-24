package com.blackblaze.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "public", name = "test")
public class Test {
    @Id
    @Column(name = "id")
    public Long id;
    @Column(name = "value")
    public String value;
}
