/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class FileUploadAndDownloadController {
    @RequestMapping("testDownload")
    public ResponseEntity<byte[]> testDownload(HttpSession session)
            throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath(
                "/static/images/idea-keyboard.jpeg");
        System.out.println("File realPath: " + realPath);
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition",
                "attachment;filename=idea-keyboard.jpeg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping("testUpload")
    public String testUpload(MultipartFile uploadFile, HttpSession session) throws IOException {
        // 获取上传文件的文件名
        String fileName = uploadFile.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        fileName = uuid + suffixName;
        // 通过ServletContext获取服务器中目录路径
        ServletContext servletContext = session.getServletContext();
        String filePath = servletContext.getRealPath("file");

        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = filePath + File.separator + fileName;
        uploadFile.transferTo(new File(finalPath));
        return "success";
    }

}
