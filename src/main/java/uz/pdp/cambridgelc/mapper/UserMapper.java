package uz.pdp.cambridgelc.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import uz.pdp.cambridgelc.dto.request.UserUpdateDTO;
import uz.pdp.cambridgelc.entity.user.UserEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserEntity toEntity(UserUpdateDTO userUpdateDTO);

    UserUpdateDTO toDto(UserEntity userEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserEntity partialUpdate(UserUpdateDTO userUpdateDTO, @MappingTarget UserEntity userEntity);
}
