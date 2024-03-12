package com.beautysalon.beauty_backend.services.impl;

import com.beautysalon.beauty_backend.dto.BeautyServiceDto;
import com.beautysalon.beauty_backend.entity.BeautyService;
import com.beautysalon.beauty_backend.entity.Master;
import com.beautysalon.beauty_backend.repository.BeautyServiceRepository;
import com.beautysalon.beauty_backend.repository.MasterRepository;
import com.beautysalon.beauty_backend.services.BeautyServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BeautyServiceServiceImpl implements BeautyServiceService {

    @Autowired
    private BeautyServiceRepository beautyServiceRepository;
    @Autowired
    private MasterRepository masterRepository;


    @Override
    public List<BeautyServiceDto> getAllBeautyServices() {
        return beautyServiceRepository.findAll().stream()
                .map(entity -> BeautyServiceDto.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .type(entity.getType())
                        .price(entity.getPrice())
                        .mastersName(entity.getMasters().stream()
                                .map(masters -> masters.getNameSurname())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<BeautyServiceDto> getBeautyServicesByName(String name) {
        return beautyServiceRepository.findAllByName(name).stream()
                .map(entity -> BeautyServiceDto.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .type(entity.getType())
                        .price(entity.getPrice())
                        .mastersName(entity.getMasters().stream()
                                .map(masters -> masters.getNameSurname())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<BeautyServiceDto> getBeautyServicesByType(String type) {
        return beautyServiceRepository.findAllByType(type).stream()
                .map(entity -> BeautyServiceDto.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .type(entity.getType())
                        .price(entity.getPrice())
                        .mastersName(entity.getMasters().stream()
                                .map(masters -> masters.getNameSurname())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<BeautyServiceDto> getBeautyServicesByPrice(int price) {
        return beautyServiceRepository.findAllByPrice(price).stream()
                .map(entity -> BeautyServiceDto.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .type(entity.getType())
                        .price(entity.getPrice())
                        .mastersName(entity.getMasters().stream()
                                .map(masters -> masters.getNameSurname())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<BeautyServiceDto> getBeautyServicesByMastersName(String nameSurname) {
        return beautyServiceRepository.findAll().stream()
                .filter(beautyService -> beautyService.getMasters().stream()
                        .anyMatch(master -> master.getNameSurname().equals(nameSurname)))
                .map(entity -> BeautyServiceDto.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .type(entity.getType())
                        .price(entity.getPrice())
                        .mastersName(entity.getMasters().stream()
                                .map(masters -> masters.getNameSurname())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public BeautyServiceDto saveBeautyService(BeautyServiceDto beautyServiceDto) {
        BeautyService beautyService = BeautyService.builder()
                .id(beautyServiceDto.getId())
                .price(beautyServiceDto.getPrice())
                .name(beautyServiceDto.getName())
                .type(beautyServiceDto.getType())
//                .masters(
//                        beautyServiceDto.getMastersName().stream()
//                        .flatMap(name -> masterRepository.findAllByNameSurname(name).stream())
//                        .collect(Collectors.toList())
//                )
                .build();
        BeautyService savedBeauty = beautyServiceRepository.save(beautyService);

        return BeautyServiceDto.builder()
                .id(savedBeauty.getId())
                .name(savedBeauty.getName())
                .type(savedBeauty.getType())
                .price(savedBeauty.getPrice())
                .build();
    }

    @Override
    public void deleteBeautyServicesById(UUID id) {
        beautyServiceRepository.deleteById(id);
    }

    @Override
    public BeautyService getBeautyService(UUID id) {
        return beautyServiceRepository.getById(id);
    }
}
