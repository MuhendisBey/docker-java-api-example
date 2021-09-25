package com.muhendisbey.dockerjavaapiexample.dto;

import lombok.Data;

import java.io.File;

@Data
public class CreateDockerImageDTO
{
    File dockerFile;
    String tag;
    boolean isPull;
    boolean isUseCache;
}
