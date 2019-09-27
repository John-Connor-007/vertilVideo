package com.uco.vertilvideos.domain;

import com.uco.vertilvideos.entity.PersonEntity;
import com.uco.vertilvideos.model.PersonModel;
import com.uco.vertilvideos.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDomain {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private PersonRepository personRepository;

    public void createPerson(PersonModel personModel) throws Exception {
        PersonEntity personEntity = modelMapper.map(personModel,PersonEntity.class);
        personRepository.save(personEntity);
    }

    public PersonModel findForIdPerson(String identification) throws Exception {
        PersonEntity personEntity = personRepository.findForIdPerson(identification);
        PersonModel personModel = new PersonModel();
        if(personEntity != null) {
            personModel = modelMapper.map(personEntity, PersonModel.class);
        }
        return personModel;
    }

}
