package com.muhendisbey.dockerjavaapiexample.service;

/* TODO
    * INCompleted
 */
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.BuildImageResultCallback;
import com.github.dockerjava.api.command.InspectImageResponse;
import com.github.dockerjava.api.model.Image;
import com.muhendisbey.dockerjavaapiexample.dto.CreateDockerImageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DockerVolumeService
{
    private final DockerClient _dockerClient;

    public DockerVolumeService(DockerClient dockerClient)
    {
        _dockerClient = dockerClient;
    }

    public List<Image> getImages()
    {
        return _dockerClient.listImagesCmd()
                .withShowAll(true)
                .exec();
    }
}
