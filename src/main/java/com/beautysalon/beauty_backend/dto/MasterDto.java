package com.beautysalon.beauty_backend.dto;


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
public class MasterDto {

    private UUID id;

    @NotBlank
    @Size(min = 2, message = "Имя должно содержать не менее 2-ух символов")
    private String nameSurname;

    @NotBlank
    private int experience;

    private List<String> serviceName;
}
