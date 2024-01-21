package com.pojo.collection;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class CollectionResponse {
    private Integer elapsedMilliseconds;
    private Integer count;
    private CountFacets countFacets;
    private List<ArtObjects> artObjects = new ArrayList<ArtObjects>();
    private List<Facet> facets;



}
