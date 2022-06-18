package com.takeout.takeout_system.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModifyStoreRequest {
    private Integer id;
    private String name;
    private String address;
    private Boolean isOpened;
}
