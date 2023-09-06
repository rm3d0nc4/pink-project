package com.example.pink_project.dtos;


import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class GetProductDto {
    private UUID id;

    public GetProductDto(UUID id) {
        this.id = id;
    }
    GetProductDto() {}
}
