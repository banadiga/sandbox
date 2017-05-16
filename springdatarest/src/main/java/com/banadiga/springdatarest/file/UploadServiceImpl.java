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
public class UploadServiceImpl implements UploadService {

  @Override
  public String upload(String imageBase64) throws IOException {
    String fileName = UUID.randomUUID().toString() + ".jpg";
    byte[] decodedImg = Base64.getDecoder().decode(imageBase64.getBytes(StandardCharsets.UTF_8));
    Path destinationFile = Paths.get("./", fileName);
    Files.write(destinationFile, decodedImg);
    return fileName;
  }

  @Override
  public String download(String fileName) throws IOException {
    Path destinationFile = Paths.get("./", fileName);
    byte[] bytes = Files.readAllBytes(destinationFile);
    return new String(bytes);
  }
}
