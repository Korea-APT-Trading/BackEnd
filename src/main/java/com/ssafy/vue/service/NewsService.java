package com.ssafy.vue.service;

import com.ssafy.vue.dto.Board;
import com.ssafy.vue.dto.Item;

import java.util.List;

public interface NewsService {
    public List<Item> retrieveNews();
}
