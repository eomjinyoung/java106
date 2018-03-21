// 이 클래스는 회원 관련 기능을 모두 둔 클래스이다.
package bitcamp.java106.pms.controller;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.util.Console;
import java.util.Scanner;

public class MemberController {
    // 이 클래스를 사용하려면 keyboard 스캐너가 있어야 한다.
    // 이 클래스를 사용하기 전에 스캐너를 설정하라!
    Scanner keyScan;

    Member[] members = new Member[1000];
    int memberIndex = 0;
    
    public MemberController(Scanner scanner) {
        this.keyScan = scanner;
    }

    public void service(String menu, String option) {
        if (menu.equals("member/add")) {
            this.onMemberAdd();
        } else if (menu.equals("member/list")) {
            this.onMemberList();
        } else if (menu.equals("member/view")) {
            this.onMemberView(option);                
        } else if (menu.equals("member/update")) {
            this.onMemberUpdate(option);                
        } else if (menu.equals("member/delete")) {
            this.onMemberDelete(option);                
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    int getMemberIndex(String id) {
        for (int i = 0; i < this.memberIndex; i++) {
            if (this.members[i] == null) continue;
            if (id.equals(this.members[i].id.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    void onMemberAdd() {
        System.out.println("[회원 정보 입력]");
        Member member = new Member();
        
        System.out.print("아이디? ");
        member.id = this.keyScan.nextLine();

        System.out.print("이메일? ");
        member.email = this.keyScan.nextLine();

        System.out.print("암호? ");
        member.password = this.keyScan.nextLine();

        // 회원 정보가 담겨있는 객체의 주소를 배열에 보관한다.
        this.members[this.memberIndex++] = member;
    }

    void onMemberList() {
        System.out.println("[회원 목록]");
        for (int i = 0; i < this.memberIndex; i++) {
            if (this.members[i] == null) continue;
            System.out.printf("%s, %s, %s\n", 
                    this.members[i].id, this.members[i].email, this.members[i].password);
        }
    }

    void onMemberView(String id) {
        System.out.println("[회원 정보 조회]");
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }
        
        int i = this.getMemberIndex(id);

        if (i == -1) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            Member member = this.members[i];
            System.out.printf("아이디: %s\n", member.id);
            System.out.printf("이메일: %s\n", member.email);
            System.out.printf("암호: %s\n", member.password);
        }
    }

    void onMemberUpdate(String id) {
        System.out.println("[회원 정보 변경]");
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }
        
        int i = this.getMemberIndex(id);

        if (i == -1) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            Member member = this.members[i];
            Member updateMember = new Member();
            System.out.printf("아이디(%s)? ", member.id);
            updateMember.id = this.keyScan.nextLine();
            System.out.printf("이메일(%s)? ", member.email);
            updateMember.email = this.keyScan.nextLine();
            System.out.printf("암호? ");
            updateMember.password = this.keyScan.nextLine();
            this.members[i] = updateMember;
            System.out.println("변경하였습니다.");
        }
    }

    void onMemberDelete(String id) {
        System.out.println("[회원 정보 삭제]");
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }
        
        int i = this.getMemberIndex(id);

        if (i == -1) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                this.members[i] = null;
                System.out.println("삭제하였습니다.");
            }
        }
    }
    
}