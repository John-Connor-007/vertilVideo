package com.uco.vertilvideos.domain;

import com.uco.vertilvideos.entity.VideoEntity;
import com.uco.vertilvideos.model.VideoModel;
import com.uco.vertilvideos.repository.VideoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class VideoDomain {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private VideoRepository videoRepository;

    public void createVideo(VideoModel videoModel) throws Exception {
        VideoEntity videoEntity = modelMapper.map(videoModel, VideoEntity.class);
        videoRepository.save(videoEntity);
    }

    public List<VideoModel> searchAllVideoForPerson(int idPerson) throws Exception {
        List<VideoEntity> videoEntityList = videoRepository.searchAllVideoForPerson(idPerson);
        List<VideoModel> videoModelList = new ArrayList<>();
        if(!videoEntityList.isEmpty()){
            videoEntityList.forEach((VideoEntity videoEntity) -> {
                VideoModel videoModel = modelMapper.map(videoEntity,VideoModel.class);
                videoModelList.add(videoModel);
            });
        }
        return videoModelList;
    }
}
