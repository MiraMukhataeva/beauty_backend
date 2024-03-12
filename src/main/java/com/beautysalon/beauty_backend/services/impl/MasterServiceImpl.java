package com.beautysalon.beauty_backend.services.impl;

import com.beautysalon.beauty_backend.dto.MasterDto;
import com.beautysalon.beauty_backend.entity.Master;
import com.beautysalon.beauty_backend.repository.BeautyServiceRepository;
import com.beautysalon.beauty_backend.repository.MasterRepository;
import com.beautysalon.beauty_backend.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterRepository masterRepository;

    @Autowired
    private BeautyServiceRepository beautyServiceRepository;


    @Override
    public List<MasterDto> getAllMasters() {
        return masterRepository.findAll().stream()
                .map(entity -> MasterDto.builder()
                        .id(entity.getId())
                        .nameSurname(entity.getNameSurname())
                        .experience(entity.getExperience())
                        .serviceName(entity.getBeautyServices().stream()
                                .map(beautyServices -> beautyServices.getName())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<MasterDto> getMasterByName(String nameSurname) {
        return masterRepository.findAllByNameSurname(nameSurname).stream()
                .map(entity -> MasterDto.builder()
                        .id(entity.getId())
                        .nameSurname(entity.getNameSurname())
                        .experience(entity.getExperience())
                        .serviceName(entity.getBeautyServices().stream()
                                .map(beautyServices -> beautyServices.getName())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<MasterDto> getMasterByExperience(int experienceFrom, int experienceTo) {
        return masterRepository.findAllByExperienceBetween(experienceFrom, experienceTo).stream()
                .map(entity -> MasterDto.builder()
                        .id(entity.getId())
                        .nameSurname(entity.getNameSurname())
                        .experience(entity.getExperience())
                        .serviceName(entity.getBeautyServices().stream()
                                .map(beautyServices -> beautyServices.getName())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<MasterDto> getMasterByServiceName(String serviceName) {
        return masterRepository.findAll().stream()
                .filter(master -> master.getBeautyServices().stream()
                        .anyMatch(beautyService -> beautyService.getName().equals(serviceName)))
                .map(entity -> MasterDto.builder()
                        .id(entity.getId())
                        .nameSurname(entity.getNameSurname())
                        .experience(entity.getExperience())
                        .serviceName(entity.getBeautyServices().stream()
                                .map(beautyServices -> beautyServices.getName())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public MasterDto saveMaster(MasterDto masterDto) {
        Master master = Master.builder()
                .id(masterDto.getId())
                .nameSurname(masterDto.getNameSurname())
                .experience(masterDto.getExperience())
                .beautyServices(masterDto.getServiceName().stream()
                        .flatMap(servicename -> beautyServiceRepository.findAllByName(servicename)
                                .stream()).collect(Collectors.toList())
                )
                .build();
        Master saveMaster = masterRepository.save(master);

        return MasterDto.builder()
                .id(saveMaster.getId())
                .nameSurname(saveMaster.getNameSurname())
                .experience(saveMaster.getExperience())
                .build();
    }

    @Override
    public Master getMaster(UUID id) {
        return masterRepository.getById(id);
    }

    @Override
    public void deleteMastersById(UUID id) {
        masterRepository.deleteById(id);
    }

}
