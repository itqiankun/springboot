package com.itqiankun.controller;

import com.itqiankun.util.ObsUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UploadController {

    @Resource
    private ObsUtil obsUtil;

    @GetMapping("/")
    public String index() {
        return "upload";
    }


    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
        RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        try {
            String uploadFileUrl = obsUtil.uploadFile(file, file.getOriginalFilename());
            System.out.println(uploadFileUrl);
            redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded '" + uploadFileUrl + "'");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Server throw IOException");
            e.printStackTrace();
        }
        return "redirect:/uploadStatus";
    }


    @RequestMapping("/download")
    public void fileDownLoad(HttpServletResponse response, @RequestParam("fileName") String fileName){
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName );
        try {
            obsUtil.getFile(response, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}