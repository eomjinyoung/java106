package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Member;

public class MemberDao {
    Member[] members = new Member[1000];
    int memberIndex = 0;
    
    public void insert(Member member) {
        // 회원 정보가 담겨있는 객체의 주소를 배열에 보관한다.
        this.members[this.memberIndex++] = member;
    }
    
    public Member[] list() {
        Member[] arr = new Member[this.memberIndex];
        for (int i = 0; i < this.memberIndex; i++)
            arr[i] = this.members[i];
        return arr;
    }
    
    public Member get(String id) {
        int i = this.getMemberIndex(id);
        if (i == -1)
            return null;
        return this.members[i];
    }
    
    public void update(Member member) {
        int i = this.getMemberIndex(member.getId());
        if (i != -1)
            this.members[i] = member;
    }
    
    public void delete(String id) {
        int i = this.getMemberIndex(id);
        if (i != -1)
            this.members[i] = null;
    }
    
    // 다음 메서드는 내부에서만 사용할 것이기 때문에 공개하지 않는다.
    private int getMemberIndex(String id) {
        for (int i = 0; i < this.memberIndex; i++) {
            if (this.members[i] == null) continue;
            if (id.equals(this.members[i].getId().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    
}

//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - MemberController로부터 데이터 관리 기능을 분리하여 MemberDao 생성.






