package com.security.todo.utils.search;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SearchWriter implements SearchStrategy{

    private final String writer;

    public SearchWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder builder) {
        return builder.equal(root.get("writer"), writer);
    }
}
