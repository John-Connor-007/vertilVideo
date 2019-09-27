package com.uco.vertilvideos.controller;

import com.uco.vertilvideos.domain.VideoDomain;
import com.uco.vertilvideos.model.VideoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/videoController")
public class VideoController {

    @Autowired
    private VideoDomain videoDomain;

    @PostMapping(value = "/saveVideo", produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveVideo(@RequestBody VideoModel video) throws Exception{
        videoDomain.createVideo(video);
    }

    @PostMapping(value = "/searchAllVideoForPerson", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VideoModel> searchAllVideoForPerson(@RequestBody VideoModel video) throws Exception {
        return videoDomain.searchAllVideoForPerson(video.getIdPerson());
    }
}
