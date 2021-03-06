package com.muhendisbey.dockerjavaapiexample.service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.command.KillContainerCmd;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.PortBinding;
import com.muhendisbey.dockerjavaapiexample.dto.CreateDockerContainerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DockerContainerService
{
    private final DockerClient _dockerClient;

    public DockerContainerService(DockerClient dockerClient)
    {
        _dockerClient = dockerClient;
    }

    public List<Container> getContainers()
    {
        return _dockerClient.listContainersCmd()
                .withShowSize(true)
                .withShowAll(true)
                .exec();
    }

    public CreateContainerResponse createContainer(CreateDockerContainerDTO dto)
    {
        return _dockerClient.createContainerCmd(dto.getImageName())
                .withName(dto.getContainerName())
                .withHostName(dto.getHostname())
                .withPortBindings(PortBinding.parse(
                        dto.getPortBinding()))
                .exec();
    }

    public void startContainer(String id)
    {
        _dockerClient.startContainerCmd(id).exec();
    }

    public void stopContainer(String id)
    {
        _dockerClient.stopContainerCmd(id);
    }

    public void killContainer(String id)
    {
        _dockerClient.killContainerCmd(id);
    }

    public InspectContainerResponse inspectContianer(String id)
    {
        return _dockerClient.inspectContainerCmd(id).exec();
    }

    public void takeSnapshot(String id)
    {
        throw new UnsupportedOperationException();
    }
}
