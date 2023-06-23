package uz.pdp.cambridgelc.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import uz.pdp.cambridgelc.dto.request.UserDTO;
import uz.pdp.cambridgelc.dto.request.UserUpdateForAdminDTO;
import uz.pdp.cambridgelc.entity.user.UserEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserUpdateMapper {
    UserUpdateMapper USER_UPDATE_MAPPER = Mappers.getMapper(UserUpdateMapper.class);

    UserEntity toEntity(UserUpdateForAdminDTO updateDTO);

    UserUpdateForAdminDTO toDto(UserEntity userEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserEntity partialUpdate(UserUpdateForAdminDTO userDTO, @MappingTarget UserEntity userEntity);
}
