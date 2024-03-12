package com.beautysalon.beauty_backend.controller;

import com.beautysalon.beauty_backend.dto.BeautyServiceDto;
import com.beautysalon.beauty_backend.entity.BeautyService;
import com.beautysalon.beauty_backend.services.BeautyServiceService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/beautyServices")
public class BeautyServiceController {

    @Autowired
    private BeautyServiceService beautyServicesService;

    @Operation(summary = "Возвращает список всех оказываемых услуг")
    @GetMapping("/all")
    public List<BeautyServiceDto> getAllBeautyServices() {
        return beautyServicesService.getAllBeautyServices();
    }

    @Operation(summary = "Возвращает список всех оказываемых услуг по наименованию")
    @GetMapping("/allByName")
    public List<BeautyServiceDto> getAllBeautyServicesByName(@Valid @NotBlank @Size
            (min = 2, message = "Наименование услуги должно содержать не менее 2-ух символов") String name) {
        return beautyServicesService.getBeautyServicesByName(name);
    }

    @Operation(summary = "Возвращает список всех оказываемых услуг по типу")
    @GetMapping("/allByType")
    public List<BeautyServiceDto> getAllBeautyServicesByType(@Valid @NotBlank @Size
            (min = 2, message = "Тип услуги должен содержать не менее 2-ух символов") String type) {
        return beautyServicesService.getBeautyServicesByType(type);
    }

    @Operation(summary = "Возвращает список всех оказываемых услуг по стоимости")
    @GetMapping("/allByPrice")
    public List<BeautyServiceDto> getAllBeautyServicesByPrice(@Valid @NotNull @Min
            (value = 100, message = "Стоимость не должна составлять менее 100 рублей")
                                                                  Integer price) {
        return beautyServicesService.getBeautyServicesByPrice(price);
    }

    @Operation(summary = "Возвращает список всех оказываемых услуг по имени мастера")
    @GetMapping("/allByMastersName")
    public List<BeautyServiceDto> getAllBeautyServicesByMastersName(@Valid @NotBlank @Size
            (min = 2, message = "Наименование услуги должно содержать не менее 2-ух символов") String nameSurname) {
        return beautyServicesService.getBeautyServicesByMastersName(nameSurname);
    }

    @Operation(summary = "Добавляет новые услуги")
    @PostMapping("/addNewOrUpdate")
    public BeautyServiceDto addNewBeautyService(@RequestBody BeautyServiceDto beautyServiceDto) {
        return beautyServicesService.saveBeautyService(beautyServiceDto);
    }

    @Operation(summary = "Обновляет информацию об услуге")
    @PutMapping("/addNewOrUpdate")
    public BeautyServiceDto updateBeautyServicesService(@RequestBody BeautyServiceDto beautyServiceDto) {
        return beautyServicesService.saveBeautyService(beautyServiceDto);
    }

    @Operation(summary = "Удаляет услугу")
    @DeleteMapping("/deleteById")
    public String deleteBeautyService(@RequestParam("id") UUID id) {
        beautyServicesService.deleteBeautyServicesById(id);
        return "Услуга успешно удалена";
    }


}

