package com.itqiankun.util;

import com.obs.services.ObsClient;
import com.obs.services.model.ObsObject;
import com.obs.services.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@Component
public class ObsUtil {

    @Resource
    private ObsClient obsClient;

    @Value("${huawei.obs.bucketName}")
    private String bucketName;

    //上传文件，multipartFile就是你要的文件，
    //objectKey就是文件名，如果桶中有文件夹的话，如往test文件上传test.txt文件，那么objectKey就是test/test.txt
    public String uploadFile(MultipartFile multipartFile, String objectKey) throws Exception{
        InputStream inputStream = multipartFile.getInputStream();
        PutObjectResult putObjectResult  = obsClient.putObject(bucketName, objectKey, inputStream);
        inputStream.close();
        obsClient.close();
        return putObjectResult.getObjectUrl();
    }

    public void deleteFile(String objectKey) throws Exception{
        obsClient.deleteObject(bucketName, objectKey);
        obsClient.close();
    }

    public void getFile(HttpServletResponse response,  String objectKey) throws Exception{
        ObsObject obsObject = obsClient.getObject(bucketName, objectKey);
        InputStream input = obsObject.getObjectContent();
        byte[] b = new byte[1024];
        ServletOutputStream outputStream = response.getOutputStream();
        int len;
        while ((len=input.read(b)) != -1){
            outputStream.write(b, 0, len);
        }
        input.close();
    }
}
