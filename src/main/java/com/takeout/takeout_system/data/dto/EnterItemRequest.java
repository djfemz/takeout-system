package com.takeout.takeout_system.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnterItemRequest {
    private Integer id;
    private Integer quantity;
}
