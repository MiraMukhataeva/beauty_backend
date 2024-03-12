package com.beautysalon.beauty_backend.services;

import com.beautysalon.beauty_backend.dto.MasterDto;
import com.beautysalon.beauty_backend.entity.Master;

import java.util.List;
import java.util.UUID;

public interface MasterService {

    List<MasterDto> getAllMasters();

    List<MasterDto> getMasterByName(String nameSurname);

    List<MasterDto> getMasterByExperience(int experienceFrom, int experienceTo);
    List<MasterDto> getMasterByServiceName(String serviceName);
    MasterDto saveMaster(MasterDto masterDto);
    Master getMaster(UUID id);
    void deleteMastersById(UUID id);

}
