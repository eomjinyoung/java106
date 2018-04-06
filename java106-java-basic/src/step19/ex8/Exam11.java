// IoC 컨테이너 만들기 - 의존 객체를 자동으로 주입하기
package step19.ex8;

public class Exam11 {
    int value;
    
    public Exam11() {
        this.value = 200;
    }
    
    public void print() {
        System.out.printf("value=%d\n", this.value);
    }
    
    public static void main(String[] args) throws Exception {
        ApplicationContext9 appContext = new ApplicationContext9("step19.ex7");
        Exam11 obj = (Exam11) appContext.getBean("step19.ex7.Exam10");
        obj.print();
    }
}

// 빈(bean)?
// => 인스턴스(instance), 객체(object)와 같은 의미로 사용한다.
// => 다만 자바 문법에서 정한 나름의 규칙에 따라 만든 클래스의 인스턴스를 얘기한다.
// => 그러나 현업에서는 인스턴스 또는 객체와 같은 의미로 사용한다.
// => bean = instance = object
// 
// 빈 컨테이너(bean container)?
// => 위의 ApplicationContext8 과 같이 인스턴스를 생성하고 보관하고 
//    필요할 때 리턴해주는 그런 역할을 하는 객체를 말한다.
// => 컨테이너는 객체의 '생성-실행-소멸' 즉 객체의 생명주기(lifecycle)를 관리한다.
// => 대표적인 라이브러리가 "스프링 IoC 컨테이너" 이다.
// 
// IoC 컨테이너(Inversion of Control 컨테이너)?
// => IoC 컨테이너 = 빈 컨테이너 + 의존 객체 자동 주입 
// 








