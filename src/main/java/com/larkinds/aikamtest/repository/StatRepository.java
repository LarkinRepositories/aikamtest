package com.larkinds.aikamtest.repository;

import com.larkinds.aikamtest.dto.tojson.output.CustomerStatDto;
import com.larkinds.aikamtest.dto.tojson.output.ProductExpensesDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


public interface StatRepository  {
    @Query(value = "select new com.larkinds.aikamtest.dto.tojson.output.ProductExpensesDto(p.product.name, sum(p.product.price))" +
            "from Purchase p join p.customer d WHERE d.id=:id group by p.product.name")
    List<ProductExpensesDto> getProductExpensesList(@Param("id")Long id);
    @Query(value =
            "select sum(p.product.price) from Purchase p join p.customer d where d.id=:id")
    BigDecimal getCustomerTotalExpense(@Param("id")Long id);
}
