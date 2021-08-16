package com.isa.pharmacy.mapper;

import com.isa.pharmacy.domain.Item;
import com.isa.pharmacy.dto.ItemDto;

import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {

    public static List<ItemDto> mapItemsToItemsDtos(List<Item> items) {
        return items.stream().map(ItemDto::new).collect(Collectors.toList());
    }
}
