package com.larkinds.aikamtest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
}
