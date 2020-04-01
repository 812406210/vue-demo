package com.vue.demo.controller;

import com.vue.demo.service.OCRService;
import com.vue.demo.utils.ResponseResult;
import com.vue.demo.utils.Result;
import com.vue.demo.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author yangwj
 * @date 2020/3/30 14:47
 */
@RestController
public class OcrController {

    @Autowired
    private OCRService ocrService;

    @RequestMapping(value = "/getCharacterFromPic",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Result getCharacter(@RequestParam("file") MultipartFile file) {
        String result = ocrService.getCharacterFromPic(file);
        if(result==null){
           return ResponseResult.error(ResultCodeEnum.OCR_ERROR.getCode(),ResultCodeEnum.OCR_ERROR.getMessage());
        }
           return ResponseResult.success(result);
    }

    @RequestMapping(value = "/getLanguage",method = RequestMethod.GET)
    @CrossOrigin
    public Result getLanguage(String language) {
        String result = ocrService.getLanguage(language);
        if(result==null){
            return ResponseResult.error(ResultCodeEnum.OCR_LANGUAGE_ERROR.getCode(),ResultCodeEnum.OCR_LANGUAGE_ERROR.getMessage());
        }
        return ResponseResult.success(result);
    }


}
