package io.sohan.Springbatchdemo.service;

import io.sohan.Springbatchdemo.model.Image;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageUploader {
//    @Value("${image.path}")
    private Path destination;

    private ImageService imageService;

    public ImageUploader(@Value("${image.path}")String destination, ImageService imageService) {//
        this.destination = Paths.get(destination);
        this.imageService = imageService;
    }

    public void store (MultipartFile file) throws IOException {
//        Path paths = Paths.get(imgPath);
        Image image=new Image();
        //check directory is exist or not
        if (!Files.isDirectory(destination)) {
            try {
                //create directory
                Files.createDirectory(destination);
            } catch (Exception e) {
                throw new IOException("Could not initialize storage\n" + e.getMessage());
            }
        }
        try{
        //Save image information
        image.setName(file.getName());
        image.setSize(String.valueOf(file.getSize()));
        image.setType(file.getContentType());
        imageService.add(image);
        //Transfer file to destination
        Path path=Paths.get(destination + "\\" + file.getOriginalFilename());
        file.transferTo(path);

        }   catch (IOException e){
            throw new IOException("Failed to store\n"+e.getMessage());
        }

    }

    public void delete(long id) throws IOException {
        //delete from db and get file name
        String img=imageService.deleteImg(id);

        //delete from destiantion
        Files.delete(Paths.get(destination + "\\" + img));
    }
}
