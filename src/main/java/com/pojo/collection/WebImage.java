package com.pojo.collection;

import lombok.Data;

@Data
public class WebImage {
    private String guid;
    private Integer offsetPercentageX;
    private Integer offsetPercentageY;
    private Integer width;
    private Integer height;
    private String url;

}
