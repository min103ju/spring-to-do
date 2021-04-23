package com.security.todo.utils.search;

import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

public interface SearchStrategy<T> extends Specification<T>{

}
