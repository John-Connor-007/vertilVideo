package com.uco.vertilvideos.controller;

import com.uco.vertilvideos.domain.PersonDomain;
import com.uco.vertilvideos.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/personController")
public class PersonController {

    @Autowired
    private PersonDomain personDomain;

    @PostMapping(value = "/savePerson", produces = MediaType.APPLICATION_JSON_VALUE)
    public void savePerson(@RequestBody PersonModel person) throws Exception{
        personDomain.createPerson(person);
    }

    @PostMapping(value = "/findForIdPerson", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonModel findForIdPerson(@RequestBody PersonModel person) throws Exception{
        return personDomain.findForIdPerson(person.getIdentification());
    }
}
