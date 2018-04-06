// 응용 - 3) 특정 패키지의 .class 파일의 목록을 알아내기
package step18.ex7;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;

public class Exam03 {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource("step18/ex6");
        
        File file = new File(url.getPath());
        File[] list = file.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                if (name.endsWith(".class") && !name.contains("$"))
                    return true;
                return false;
            }
        });
        
        for (File f : list) {
            System.out.println(f.getName());
        }
        
        
        
    }
}






