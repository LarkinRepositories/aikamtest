package com.larkinds.aikamtest.repository;

import com.larkinds.aikamtest.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>, StatRepository {
    /**
     * Returns all purchases been created in start-end interval of time
     * @param start search start date
     * @param end search end date
     * @return list of purchases matched @param criteria
     */
    List<Purchase> findAllByCreatedBetween(LocalDate start, LocalDate end);

}
