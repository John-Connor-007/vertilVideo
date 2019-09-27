package com.uco.vertilvideos.domain;

import com.uco.vertilvideos.entity.VideoEntity;
import com.uco.vertilvideos.model.VideoModel;
import com.uco.vertilvideos.repository.VideoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class VideoDomainTest {

    @InjectMocks
    private VideoDomain videoDomain;
    @MockBean
    private VideoRepository videoRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSearchAllVideoForPersonWhenFindOnePersonReturnAllVideo() throws Exception {
        List<VideoEntity> videoEntityList = new ArrayList<>();
        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setId(1);
        videoEntity.setIdCategory(1);
        videoEntity.setIdPerson(1);
        videoEntity.setTitle("Skynet");
        videoEntity.setUrl("localhost:8081/h2");
        videoEntityList.add(videoEntity);
        Mockito.when(videoRepository.searchAllVideoForPerson(1)).thenReturn(videoEntityList);

        List<VideoModel> videoModelList = videoDomain.searchAllVideoForPerson(1);

        Assert.assertEquals(videoEntityList.get(0).getId(),videoModelList.get(0).getId());
        Assert.assertEquals(videoEntityList.get(0).getIdCategory(),videoModelList.get(0).getIdCategory());
        Assert.assertEquals(videoEntityList.get(0).getIdPerson(),videoModelList.get(0).getIdPerson());
        Assert.assertEquals(videoEntityList.get(0).getTitle(),videoModelList.get(0).getTitle());
        Assert.assertEquals(videoEntityList.get(0).getUrl(),videoModelList.get(0).getUrl());
        Assert.assertFalse(videoModelList.isEmpty());
    }

    @Test
    public void testSearchAllVideoForPersonWheNotFindPersonReturnEmpty() throws Exception {
        List<VideoEntity> videoEntityList = new ArrayList<>();
        Mockito.when(videoRepository.searchAllVideoForPerson(1)).thenReturn(videoEntityList);

        List<VideoModel> videoModelList = videoDomain.searchAllVideoForPerson(1);

        Assert.assertTrue(videoModelList.isEmpty());
    }
}
