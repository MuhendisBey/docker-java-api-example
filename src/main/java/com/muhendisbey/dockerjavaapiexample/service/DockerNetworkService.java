package com.muhendisbey.dockerjavaapiexample.service;

/* TODO
    * INCompleted
 */
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DockerNetworkService
{
    private final DockerClient _dockerClient;

    public DockerNetworkService(DockerClient dockerClient)
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
