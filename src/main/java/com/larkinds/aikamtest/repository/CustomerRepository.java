package com.larkinds.aikamtest.repository;

import com.larkinds.aikamtest.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    /**
     * Returns a list of all customers having specific last name
     * @param lastName last name to search to
     * @return List of all customers having specific last name
     */
    List<Customer> findAllByLastName(String lastName);

    /**
     * Returns a list of all customers which had bought specific product certain amount of times
     * @param productName name of the product
     * @param purchaseCount amount of times a customer should've bought it
     * @return List of all customers who had bought specific product certain amount of times
     */
    @Query(value = "select p.customer from Purchase p join p.customer d " +
            "WHERE p.product.name=:productName group by d.id having count(p.customer) >= :purchaseCount")
    List<Customer> findByProductNameAndPurchaseCount(@Param("productName") String productName,
                                                     @Param("purchaseCount") long purchaseCount);

    /**
     * Returns all customers which total amount of money spent on products in a certain interval
     * @param minValue minimum amount of money spent
     * @param maxValue maximum amount of money spent
     * @return List of all customers which total amount of money spent on products is in minValue-maxValue interval
     */
    @Query(value ="select p.customer from Purchase p join p.customer d group by d.id " +
                    "having sum(p.product.price) between :minValue and :maxValue")
    List<Customer> findAllWithExpense(@Param("minValue") BigDecimal minValue, @Param("maxValue") BigDecimal maxValue);

    /**
     * Returns list of first N customers bought the least amount of products
     * @param pageable N limit
     * @return list of first N customer bought the lease amount ot products
     */
    @Query(value = "select p.customer from Purchase p join p.customer d group by d.id ORDER BY count(p.product)")
    Page<Customer> findBadCustomers(Pageable pageable);

}
