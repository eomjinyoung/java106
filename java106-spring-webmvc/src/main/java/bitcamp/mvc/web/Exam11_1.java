// 파일 업로드
package bitcamp.mvc.web;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller 
@RequestMapping("/exam11_1") 
public class Exam11_1 {
    
    @PostMapping("upload01")
    public void upload01(
            String name, 
            int age,
            MultipartFile[] files, 
            Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        int i = 0;
        for (MultipartFile file : files) {
            model.addAttribute("file" + i + "Original", file.getOriginalFilename());
            model.addAttribute("file" + i + "New", UUID.randomUUID());
            i++;
        }
    }
}







