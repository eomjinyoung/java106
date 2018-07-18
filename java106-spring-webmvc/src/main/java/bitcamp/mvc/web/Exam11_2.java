// 파일 업로드 - JSON
package bitcamp.mvc.web;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController 
@RequestMapping("/exam11_2") 
public class Exam11_2 {
    
    @Autowired ServletContext sc;
    
    @PostMapping("upload01")
    public Object upload01(
            MultipartFile[] files) {
        
        HashMap<String,Object> jsonData = new HashMap<>();
        
        String filesDir = sc.getRealPath("/files");
        
        int i = 0;
        for (MultipartFile file : files) {
            String filename = UUID.randomUUID().toString();
            jsonData.put("file" + i + "_original", file.getOriginalFilename());
            jsonData.put("file" + i + "_new", filename);
            i++;
            try {
                File path = new File(filesDir + "/" + filename);
                System.out.println(path);
                file.transferTo(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jsonData;
    }
}







