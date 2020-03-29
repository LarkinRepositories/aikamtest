package com.larkinds.aikamtest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "purchases")
public class Purchase extends BaseEntity {
    @CreatedDate
    @Column(name = "created")
    private LocalDateTime created;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id" )
    Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    Product product;

}
