package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.controller.PropertyController;
import com.mycompany.property_management.converter.PropertyConverter;
import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.repository.PropertyRepository;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository  propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity propertyEntity = propertyRepository.save(propertyConverter.convertDTOtoEntity(propertyDTO));
        propertyDTO = propertyConverter.convertEntitytoDTO(propertyEntity);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listOfProperties = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> listOfProps = new LinkedList<>();
        for(PropertyEntity pe : listOfProperties ){
            PropertyDTO propertyDTO = propertyConverter.convertEntitytoDTO(pe);
            listOfProps.add(propertyDTO);
        }
        return listOfProps;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
          Optional<PropertyEntity> optEntity = propertyRepository.findById(propertyId);
          if(optEntity.isPresent()){
              PropertyEntity propertyEntity = propertyConverter.convertDTOtoEntity(propertyDTO);
              propertyEntity.setId(optEntity.get().getId());
              PropertyEntity pe = propertyRepository.save(propertyEntity);
              propertyDTO = propertyConverter.convertEntitytoDTO(pe);
          }
        return propertyDTO;
    }

    @Override
    public PropertyDTO updateDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEntity = propertyRepository.findById(propertyId);
        if(optEntity.isPresent()){
            PropertyEntity propertyEntity = optEntity.get();
            propertyEntity.setDescription(propertyDTO.getDescription());
            PropertyEntity pe = propertyRepository.save(propertyEntity);
            propertyDTO = propertyConverter.convertEntitytoDTO(pe);
        }
        return propertyDTO;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
