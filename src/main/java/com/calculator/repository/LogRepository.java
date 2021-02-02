package com.calculator.repository;

import com.calculator.entity.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface LogRepository extends CrudRepository<Log, Long> {
    List<Log> findAll();

    Optional<Log> findByExpression(String expression);

    List<Log> findByCallDateBetween(Date dateStart, Date dateEnd);
}
