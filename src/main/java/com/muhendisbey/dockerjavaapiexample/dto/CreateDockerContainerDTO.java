package com.muhendisbey.dockerjavaapiexample.dto;

import lombok.Data;

@Data
public class CreateDockerContainerDTO
{
    String imageName;
    String containerName;
    String hostname;
    InOutDockerParameter portBinding;
    InOutDockerParameter volumeBinding;
}
