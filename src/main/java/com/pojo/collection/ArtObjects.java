package com.pojo.collection;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ArtObjects {
    private Links links;
    private String id;
    private String objectNumber;
    private String title;
    private Boolean hasImage;
    private String principalOrFirstMaker;
    private String longTitle;
    private Boolean showImage;
    private Boolean permitDownload;
    private WebImage webImage;
    private HeaderImage headerImage;
    private List<String> productionPlaces = new ArrayList<String>();



}
