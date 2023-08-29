package com.example.callToApi.mapper;

import com.example.callToApi.dto.DriverDto;
import com.example.callToApi.entity.Driver;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDriverMapper {

    Driver entityToDto(Driver entity);

    Driver DtoToEntity(DriverDto dto);

    List<Driver> dtoToEntityList(List<DriverDto> dto);

    List<DriverDto> entityToDtoList(List<Driver> entity);


}
