package com.security.todo.utils.search;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SearchContent implements SearchStrategy{

    private final String search;

    public SearchContent(String search) {
        this.search = search;
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder builder) {
        if(StringUtils.hasLength(this.search))
            return builder.like(builder.upper(root.get("content")), "%" + search.toUpperCase() + "%");
        else
            return null;
    }
}
