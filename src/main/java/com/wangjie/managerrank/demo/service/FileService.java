package com.wangjie.managerrank.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    private Logger log = LoggerFactory.getLogger(FileService.class);

    private Path rootLocation;

    public FileService(String rootLocation){
        this.rootLocation = Paths.get(rootLocation);
    }

    public Resource loadFile(String filename){
        try{
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()){
                return resource;
            }else {
                throw new RuntimeException("FAIL");
            }
        }catch (MalformedURLException e){
            throw new RuntimeException("FAIL");
        }
    }

    public void init(){
        try{
            Files.createDirectories(rootLocation);
        }catch (IOException e){
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}
