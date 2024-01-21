package com.pojo.collection;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Facet {
    private List<Facet_> facets = new ArrayList<Facet_>();
    private String name;
    private Integer otherTerms;
    private Integer prettyName;
}
