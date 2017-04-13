package com.banadiga.http2.constoller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

@Controller
public class MyController {

  @RequestMapping(value = "/{id1}/{id2}.jpg", method = RequestMethod.GET)
  public ResponseEntity matrixMinPlus(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2,
                                      @RequestParam(value = "width", required = false) Integer width,
                                      @RequestParam(value = "height", required = false) Integer height) {
    try {
      if (width == null) width = 20;
      if (height == null) height = 20;

      BufferedImage img = new BufferedImage(width, height, TYPE_INT_RGB);
      int color = new Color((int) (Math.random() * 0x1000000)).getRGB();
      for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
          img.setRGB(x, y, color);
        }
      }

      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ImageIO.write(img, "jpg", baos);
      byte[] imageInByte = baos.toByteArray();

      final HttpHeaders headers = new HttpHeaders();
      headers.setContentType(new MediaType("image", "jpeg"));
      return new ResponseEntity(imageInByte, headers, HttpStatus.CREATED);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
