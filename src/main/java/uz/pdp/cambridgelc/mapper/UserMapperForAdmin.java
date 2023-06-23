package uz.pdp.cambridgelc.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import uz.pdp.cambridgelc.dto.request.UserDTO;
import uz.pdp.cambridgelc.entity.user.UserEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapperForAdmin {
    UserMapperForAdmin USER_MAPPER_FOR_ADMIN = Mappers.getMapper(UserMapperForAdmin.class);

    UserEntity toEntity(UserDTO userDTO);

    UserDTO toDto(UserEntity userEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserEntity partialUpdate(UserDTO userDTO, @MappingTarget UserEntity userEntity);
}
