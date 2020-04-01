package com.vue.demo.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author yangwj
 * @date 2020/4/1 9:26
 */
public interface OCRService {

    String getCharacterFromPic( MultipartFile file);

    String getLanguage(String language);
}
