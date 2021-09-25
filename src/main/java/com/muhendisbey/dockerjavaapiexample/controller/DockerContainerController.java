package com.muhendisbey.dockerjavaapiexample.controller;

import com.github.dockerjava.api.command.*;
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

    @PostMapping("container/{id}/start")
    void startContainer(@PathVariable String id)
    {
        _dockerContainerManagementService.startContainer(id);
    }

    @PostMapping("container/{id}/stop")
    void stopContainer(@PathVariable String id)
    {
        _dockerContainerManagementService.stopContainer(id);
    }

    @PostMapping("container/{id}/kill")
    void killContainer(@PathVariable String id)
    {
        _dockerContainerManagementService.killContainer(id);
    }

    @GetMapping("container/{id}")
    InspectContainerResponse inspectContianer(@PathVariable String id)
    {
        return _dockerContainerManagementService.inspectContianer(id);
    }

    @PutMapping("container/{id}/take-snapshot")
    void takeSnapshot(@PathVariable String id)
    {
        _dockerContainerManagementService.takeSnapshot(id);
    }

}
