package com.vue.demo.test;

/**
 * @author yangwj
 * @date 2020/7/2 15:12
 */

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/excel")
public class ExcelController {
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void excel(HttpServletResponse response) throws Exception {
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList();
        titles.add("a1");
        titles.add("a2");
        titles.add("a3");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList();
        List<Object> row = new ArrayList();
        row.add("11111111111");
        row.add("22222222222");
        row.add("3333333333");

        rows.add(row);

        data.setRows(rows);


        //生成本地
//	        File f = new File("D:\\test.xlsx");
//	        FileOutputStream out = new FileOutputStream(f);
//	        ExcelUtils.exportExcel(data, out);
//	        out.close();
        SimpleDateFormat fdate=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String fileName=fdate.format(new Date())+".xls";
        ExcelUtils.exportExcel(response,fileName,data);
    }
}