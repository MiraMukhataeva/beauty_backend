package com.beautysalon.beauty_backend.controller;

import com.beautysalon.beauty_backend.dto.MasterDto;
import com.beautysalon.beauty_backend.entity.Master;
import com.beautysalon.beauty_backend.services.MasterService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/masters")
@Validated
public class MasterController {

    @Autowired
    public MasterService masterService;

    @Operation(summary = "Возвращает список всех мастеров")
    @GetMapping("/all")
    public List<MasterDto> getAllMasters() {
        return masterService.getAllMasters();
    }

    @Operation(summary = "Возвращает список всех мастеров по имени")
    @GetMapping("/allByNameSurname")
    public List<MasterDto> getAllMastersByNameSurname( @Valid @NotBlank @Size
            (min = 2, message = "Имя должно содержать не менее 2-ух символов")
                                                           String nameSurname) {
        return masterService.getMasterByName(nameSurname);
    }

    @Operation(summary = "Возвращает список всех мастеров по опыту")
    @GetMapping("/allByExperience")
    public List<MasterDto> getAllMastersByExperience(@Valid @NotNull Integer experienceFrom, Integer experienceTo) {
        return masterService.getMasterByExperience(experienceFrom, experienceTo);
    }

    @Operation(summary = "Возвращает список всех мастеров по оказываемым ими услугам")
    @GetMapping("/allByServiceName")
    public List<MasterDto> getAllMastersByServiceName(@Valid @NotBlank String serviceName) {
        return masterService.getMasterByServiceName(serviceName);
    }

    @Operation(summary = "Добавляет нового мастера")
    @PostMapping("/addNewOrUpdate")
    public MasterDto addNewMaster(@RequestBody MasterDto mastersDto) {
        return masterService.saveMaster(mastersDto);
    }

    @Operation(summary = "Обновляет информацию о мастере")
    @PutMapping("/addNewOrUpdate")
    public MasterDto updateMaster(@RequestBody MasterDto masterDto) {
        return masterService.saveMaster(masterDto);
    }

    @Operation(summary = "Удаляет мастера")
    @DeleteMapping("/deleteById")
    public String deleteMaster(@RequestParam("id") UUID id) {
        masterService.deleteMastersById(id);
        return "Мастер успешно удален";
    }

}
