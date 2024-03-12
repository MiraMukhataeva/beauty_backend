package com.beautysalon.beauty_backend.services;

import com.beautysalon.beauty_backend.dto.BeautyServiceDto;
import com.beautysalon.beauty_backend.entity.BeautyService;

import java.util.List;
import java.util.UUID;

public interface BeautyServiceService {

    List<BeautyServiceDto> getAllBeautyServices();

    List<BeautyServiceDto> getBeautyServicesByName(String name);

    List<BeautyServiceDto> getBeautyServicesByType(String type);

    List<BeautyServiceDto> getBeautyServicesByPrice(int price);
    List<BeautyServiceDto> getBeautyServicesByMastersName(String nameSurname);
    BeautyServiceDto saveBeautyService(BeautyServiceDto beautyServiceDto);
    void deleteBeautyServicesById(UUID id);
    BeautyService getBeautyService(UUID id);

}
