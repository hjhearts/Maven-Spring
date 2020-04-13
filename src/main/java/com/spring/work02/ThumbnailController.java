package com.spring.work02;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@Controller
public class ThumbnailController {
    @RequestMapping(value = "/download")
    protected void download(@RequestParam("imageFileName") String imageFileName,
                            HttpServletResponse response) throws Exception{
        OutputStream out = response.getOutputStream();
        String CURR_IMAGE_REPO_PATH = "c:/spring/image_repo";
        String filePath = CURR_IMAGE_REPO_PATH + "/" + imageFileName;
        File image = new File(filePath);
        int lastIndex = imageFileName.lastIndexOf(".");
        String fileName = imageFileName.substring(0, lastIndex);
        File thumbnail = new File(CURR_IMAGE_REPO_PATH + "/thumbnail/" + fileName + ".png");
        response.setHeader("Cache-Control", "no-cache");
        response.addHeader("Content-disposition", "attachment; fileName=" + imageFileName);
        if(image.exists()){
            Thumbnails.of(image).size(50, 50).outputFormat("png").toOutputStream(out);
        }else{
            return;
        }
        byte[] buffer = new byte[1024 * 8];
        out.write(buffer);
        out.close();
    }
}
