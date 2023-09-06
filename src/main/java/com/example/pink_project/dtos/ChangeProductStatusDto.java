package com.example.pink_project.dtos;


import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class ChangeProductStatusDto {
    private UUID id;

    public ChangeProductStatusDto(UUID id) {
        this.id = id;
    }
    ChangeProductStatusDto() {}
}
