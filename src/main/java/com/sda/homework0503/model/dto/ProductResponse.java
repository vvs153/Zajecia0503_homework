package com.sda.homework0503.model.dto;

import com.sda.homework0503.model.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    Long id;
    String name;
    LocalDate expDate;
    Double quantity;
    Unit unit;
}
