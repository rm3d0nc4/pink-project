package com.example.pink_project.dtos;


import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class RemoveProductDto {
    private UUID id;

    public RemoveProductDto(UUID id) {
        this.id = id;
    }
    RemoveProductDto() {}
}
