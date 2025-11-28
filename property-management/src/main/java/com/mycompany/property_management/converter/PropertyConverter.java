package com.mycompany.property_management.converter;

import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){

        PropertyEntity pe = new PropertyEntity();
        pe.setId(propertyDTO.getId());
        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setAddress(propertyDTO.getAddress());
        pe.setPrice(propertyDTO.getPrice());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());

        return pe;
    }
    public PropertyDTO convertEntitytoDTO(PropertyEntity propertyEntity){

       PropertyDTO propertyDTO = new PropertyDTO();

       propertyDTO.setId(propertyEntity.getId());
       propertyDTO.setAddress(propertyEntity.getAddress());
       propertyDTO.setDescription(propertyEntity.getDescription());
       propertyDTO.setPrice(propertyEntity.getPrice());
       propertyDTO.setTitle(propertyEntity.getTitle());
       propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
       propertyDTO.setOwnerName(propertyEntity.getOwnerName());

       return propertyDTO;

    }
}
