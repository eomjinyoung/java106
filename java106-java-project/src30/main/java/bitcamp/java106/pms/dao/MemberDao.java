package bitcamp.java106.pms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Member;

@Component
public class MemberDao extends AbstractDao<Member> {
    public MemberDao() throws Exception {
        load();
    }
    
    public void load() throws Exception {
        try (
                ObjectInputStream in = new ObjectInputStream(
                               new BufferedInputStream(
                               new FileInputStream("data/member.data")));
            ) {
        
            while (true) {
                try {
                    this.insert((Member) in.readObject());
                } catch (Exception e) { // 데이터를 모두 읽었거나 파일 형식에 문제가 있다면,
                    //e.printStackTrace();
                    break; // 반복문을 나간다.
                }
            }
        }
    }
    
    public void save() throws Exception {
        try (
                ObjectOutputStream out = new ObjectOutputStream(
                                new BufferedOutputStream(
                                new FileOutputStream("data/member.data")));
            ) {
            Iterator<Member> members = this.list();
            
            while (members.hasNext()) {
                out.writeObject(members.next());
            }
        } 
    }
        
    public int indexOf(Object key) {
        String id = (String) key;
        for (int i = 0; i < collection.size(); i++) {
            Member originMember = collection.get(i);
            if (originMember.getId().toLowerCase().equals(id.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    
}

//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList를 사용하여 객체(의 주소) 목록을 관리한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - MemberController로부터 데이터 관리 기능을 분리하여 MemberDao 생성.






