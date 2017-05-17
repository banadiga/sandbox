package com.banadiga.springdatarest.file;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Slf4j
@Service
public class FileService {

  public String upload(String imageBase64) throws FileNotFoundException {
    try {
      String fileName = UUID.randomUUID().toString() + ".jpg";
      byte[] decodedImg = Base64.getDecoder().decode(imageBase64.getBytes(StandardCharsets.UTF_8));
      Path destinationFile = Paths.get("./", fileName);
      Files.write(destinationFile, decodedImg);
      return fileName;
    } catch (Exception e) {
      throw new FileNotFoundException();
    }
  }

  public void delete(String fileName) throws FileNotFoundException {
    try {
      Path destinationFile = Paths.get("./", fileName);
      Files.delete(destinationFile);
    } catch (IOException e) {
      throw new FileNotFoundException();
    }
  }

  public String download(String fileName) throws FileNotFoundException {
    try {
      Path destinationFile = Paths.get("./", fileName);
      byte[] bytes = Files.readAllBytes(destinationFile);
      return new String(bytes);
    } catch (IOException e) {
      throw new FileNotFoundException();
    }
  }
}
