package bitcamp.java106.pms.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {
    
    ClassroomDao classroomDao;
    
    public ClassroomController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @RequestMapping("/form")
    public void form(){
    }
    
    @RequestMapping("/add")
    public String add(Classroom classroom) throws Exception {
        
        classroomDao.insert(classroom);
        return "redirect:list";
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam("no") int no) throws Exception {
     
        int count = classroomDao.delete(no);
        if (count == 0) {
            throw new Exception("<p>해당 강의가 없습니다.</p>");
        }
        return "redirect:list";
    }
    
    @RequestMapping("/list")
    public void list(Map<String,Object> map) throws Exception {
     
        List<Classroom> list = classroomDao.selectList();
        map.put("list", list);
    }
    
    @RequestMapping("/update")
    public String update(Classroom classroom) throws Exception {
     
        int count = classroomDao.update(classroom);
        if (count == 0) {
            throw new Exception("해당 강의가 존재하지 않습니다.");
        }
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public String view(
            @PathVariable int no, 
            Map<String,Object> map) throws Exception {
     
        Classroom classroom = classroomDao.selectOne(no);

        if (classroom == null) {
            throw new Exception("유효하지 않은 강의입니다.");
        }
        map.put("classroom", classroom);
        return "classroom/view";
    }
    
    // GlobalBindingInitializer 에 등록했기 때문에 이 클래스에서는 제외한다.
    /*
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
                java.sql.Date.class, 
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        this.setValue(java.sql.Date.valueOf(text));
                    }
                });
    }
    */
}

//ver 52 - InternalResourceViewResolver 적용
//         *.do 대신 /app/* 을 기준으로 URL 변경
//ver 51 - Spring WebMVC 적용
//ver 49 - 요청 핸들러의 파라미터 값 자동으로 주입받기
//ver 48 - CRUD 기능을 한 클래스에 합치기
//ver 47 - 애노테이션을 적용하여 요청 핸들러 다루기
//ver 46 - 페이지 컨트롤러를 POJO를 변경
//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 40 - 필터 적용
//ver 39 - forward 적용
//ver 38 - redirect 적용
//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - ClassroomController에서 add() 메서드를 추출하여 클래스로 정의.
