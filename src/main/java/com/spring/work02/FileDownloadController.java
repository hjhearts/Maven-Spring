package com.spring.work02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@Controller
public class FileDownloadController {

    @RequestMapping(value = "/download")
    protected void download(@RequestParam("imageFileName") String imageFileName,
                            HttpServletResponse response) throws Exception{
        OutputStream out = response.getOutputStream();
        String CURR_IMAGE_REPO_PATH = "c:/spring/image_repo";
        String downFile = CURR_IMAGE_REPO_PATH + "/" + imageFileName;
        File file = new File(downFile);
        response.setHeader("Cache-Control", "no-cache");
        response.addHeader("Content-disposition", "attachment; fileName=" + imageFileName);
        FileInputStream in = new FileInputStream(file);
        byte[] buffer = new byte[1024 * 8];
        while(true){
            int count = in.read(buffer);
            if(count == -1) break;
            out.write(buffer, 0, count);
        }
        in.close();
        out.close();
    }
}
