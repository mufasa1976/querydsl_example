package io.github.mufasa1976.example.querydsl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface SomeTableRepository extends JpaRepository<SomeTable, Long>, QueryDslPredicateExecutor<SomeTable> {
}
