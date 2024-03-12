package com.beautysalon.beauty_backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BeautyServiceDto {

    private UUID id;

    @NotBlank
    @Size(min = 2, message = "Наименование услуги должно содержать не менее 2-ух символов")
    private String name;

    @NotBlank
    @Min(value = 100, message = "Стоимость не должна составлять менее 100 рублей")
    private int price;

    @NotBlank
    @Size(min = 2, message = "Тип услуги должен содержать не менее 2-ух символов")
    private String type;

    private List<String> mastersName;

}
