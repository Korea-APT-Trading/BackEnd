package com.ssafy.vue.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "News (뉴스정보)", description = "뉴스 제목, 원본 링크, 링크, 본문, 발행날짜")
public class Item {
    @ApiModelProperty(value = "제목")
    String title;
    @ApiModelProperty(value = "원본 링크")
    String originalLink;
    @ApiModelProperty(value = "링크")
    String link;
    @ApiModelProperty(value = "본문")
    String description;
    @ApiModelProperty(value = "발행날자")
    String pubData;

    public String getTitle() {
        return title;
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getPubData() {
        return pubData;
    }
}
