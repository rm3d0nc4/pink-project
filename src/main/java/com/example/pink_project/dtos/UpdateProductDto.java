package com.example.pink_project.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
public class UpdateProductDto {
    private UUID id;
    private String name;
    private Boolean available;
    private String destination;
    private Integer returnFee;
    private Integer minimumTerm;
    private Double administrationFee;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;
    private Boolean dailyLiquidity;

    public UpdateProductDto() {}
}
