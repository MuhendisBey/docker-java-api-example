package com.muhendisbey.dockerjavaapiexample.service;

/* TODO
    * Un tested
 */
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.BuildImageResultCallback;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.command.InspectImageResponse;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.PortBinding;
import com.muhendisbey.dockerjavaapiexample.dto.CreateDockerContainerDTO;
import com.muhendisbey.dockerjavaapiexample.dto.CreateDockerImageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DockerImageService
{
    private final DockerClient _dockerClient;

    public DockerImageService(DockerClient dockerClient)
    {
        _dockerClient = dockerClient;
    }

    public List<Image> getImages()
    {
        return _dockerClient.listImagesCmd()
                .withShowAll(true)
                .exec();
    }

    public String createImage(CreateDockerImageDTO dto)
    {
        return _dockerClient.buildImageCmd()
                .withDockerfile(dto.getDockerFile())
                .withPull(dto.isPull())
                .withNoCache(dto.isUseCache())
                .exec(new BuildImageResultCallback())
                .awaitImageId();
    }

    public InspectImageResponse inspectImage(String id)
    {
        return _dockerClient.inspectImageCmd(id).exec();
    }

    public void tagImage(String id, String repository, String tag)
    {
        _dockerClient.tagImageCmd(id, repository, tag).exec();
    }
}
