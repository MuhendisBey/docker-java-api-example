package com.muhendisbey.dockerjavaapiexample.controller;

import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Container;
import com.muhendisbey.dockerjavaapiexample.dto.CreateDockerContainerDTO;
import com.muhendisbey.dockerjavaapiexample.service.DockerContainerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/docker-container-management")
public class DockerContainerController
{
    private final DockerContainerService _dockerContainerManagementService;

    public DockerContainerController(DockerContainerService dockerContainerManagementService)
    {
        _dockerContainerManagementService = dockerContainerManagementService;
    }

    @GetMapping("containers")
    List<Container> getContainers()
    {
        return _dockerContainerManagementService.getContainers();
    }

    @PutMapping("container/create")
    CreateContainerResponse createContainer(@RequestBody CreateDockerContainerDTO dto)
    {
        return _dockerContainerManagementService.createContainer(dto);
    }
}
