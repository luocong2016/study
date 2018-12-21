package com.chapter.chapter1.web;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class HelloController {
    private final static String filePath = "C://data/";

    @GetMapping("/get/{id}")
    public String get(@PathVariable("id") String id) {
        return id;
    }

    @PostMapping("/post")
    public Object post(String user, String password) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.clear();
        params.put("username", user);
        params.put("password", password);
        return params;
    }

    @PutMapping("/put")
    public String put(String id) {
        return id;
    }

    @DeleteMapping("/delete")
    public String delete(String id) {
        return id;
    }

    @RequestMapping("/upload")
    public Object upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        Map map = new HashMap();

        String name = request.getParameter("name");
        // 文件名
        String fileName = file.getOriginalFilename();
        // 文件后缀
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 重新生成唯一文件名，用于存储数据库
        String newFileName = UUID.randomUUID().toString() + suffixName;

        System.out.printf("姓名：%s \n文件名：%s\n文件后缀名：%s\n新的文件名：%s", name, fileName, suffixName, newFileName);

        // 创建文件
        File dest = new File(filePath + newFileName);
        map.put("filePath", dest.getAbsolutePath());
        map.put("name", name);
        try {
            file.transferTo(dest);
            result.put("success", true);
            result.put("data", map);
        } catch (IOException e) {
            e.printStackTrace();
            result.put("success", false);
        }

        return result;
    }
}
