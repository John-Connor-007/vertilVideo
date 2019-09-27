package com.uco.vertilvideos.domain;

import com.uco.vertilvideos.entity.PersonEntity;
import com.uco.vertilvideos.model.PersonModel;
import com.uco.vertilvideos.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PersonDomainTest {

    @InjectMocks
    private PersonDomain personDomain;

    @MockBean
    private PersonRepository personRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindForIdPersonWhenPersonExistReturnPersonModel() throws Exception {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setLastName("Connor");
        personEntity.setName("John");
        personEntity.setEmail("johnconnor@gmail.com");
        personEntity.setIdentification("007");
        Mockito.when(personRepository.findForIdPerson("007")).thenReturn(personEntity);

        PersonModel personModel = personDomain.findForIdPerson("007");

        Assert.assertEquals(personEntity.getEmail(),personModel.getEmail());
        Assert.assertEquals(personEntity.getIdentification(),personModel.getIdentification());
        Assert.assertEquals(personEntity.getName(),personModel.getName());
        Assert.assertEquals(personEntity.getLastName(),personModel.getLastName());
    }

    @Test
    public void testFindForIdPersonWhenPersonNotExistReturnEmpty() throws Exception {
        PersonEntity personEntity = new PersonEntity();
        Mockito.when(personRepository.findForIdPerson("007")).thenReturn(personEntity);

        PersonModel personModel = personDomain.findForIdPerson("007");

        Assert.assertNull(personModel.getEmail());
        Assert.assertNull(personModel.getIdentification());
        Assert.assertNull(personModel.getLastName());
        Assert.assertNull(personModel.getName());
    }
}
