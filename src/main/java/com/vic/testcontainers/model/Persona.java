package com.vic.testcontainers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Personas2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    private String mail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
