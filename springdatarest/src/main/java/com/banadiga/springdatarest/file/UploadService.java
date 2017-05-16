package com.banadiga.springdatarest.file;

import java.io.IOException;

public interface UploadService {

  String upload(final String imageBase64) throws IOException;

  String download(final String name) throws IOException;
}
