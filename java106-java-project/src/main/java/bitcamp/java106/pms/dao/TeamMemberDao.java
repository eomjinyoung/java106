package bitcamp.java106.pms.dao;

public class TeamMemberDao {
    
    private Object[][] teamMembers = new Object[1000][2];
    private int rowIndex;
    
    private int getIndex(String teamName, String memberId) {
        String ptn = teamName.toLowerCase();
        String pmi = memberId.toLowerCase();
        for (int i = 0; i < this.rowIndex; i++) {
            if (this.teamMembers[i][0] == null) continue;
            
            String tn = ((String)this.teamMembers[i][0]).toLowerCase();
            String mi = ((String)this.teamMembers[i][1]).toLowerCase();
            if (tn.equals(ptn) && mi.equals(pmi)) {
                return i;
            }
        }
        return -1;
    }
    
    public int addMember(String teamName, String memberId) {
        if (this.isExist(teamName, memberId)) { 
            return 0;
        }
        this.teamMembers[rowIndex][0] = teamName;
        this.teamMembers[rowIndex][1] = memberId;
        rowIndex++;
        return 1;
    }
    
    public int deleteMember(String teamName, String memberId) {
        int index = this.getIndex(teamName, memberId);
        if (index < 0) { // 존재하지 않는 멤버라면,
            return 0;
        }
        
        this.teamMembers[index][0] = null;
        this.teamMembers[index][1] = null;
        return 1;
    }
    
    public boolean isExist(String teamName, String memberId) {
        if (this.getIndex(teamName, memberId) < 0) {
            return false;
        } else {
            return true;
        }
    }

    private int getMemberCount(String teamName) {
        int cnt = 0;
        String ptn = teamName.toLowerCase();
        for (int i = 0; i < this.rowIndex; i++) {
            if (this.teamMembers[i][0] == null) continue;
            String tn = ((String)this.teamMembers[i][0]).toLowerCase();
            if (tn.equals(ptn)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public String[] getMembers(String teamName) {
        String ptn = teamName.toLowerCase();
        String[] members = new String[this.getMemberCount(teamName)];
        
        for (int i = 0, x = 0; i < this.rowIndex; i++) {
            if (this.teamMembers[i][0] == null) continue;
            String tn = ((String)this.teamMembers[i][0]).toLowerCase();
            if (tn.equals(ptn)) {
                members[x++] = (String)this.teamMembers[i][1];
            }
        }
        return members;
    }
}
// 용어 정리!
// 메서드 시그너처(method signature) = 함수 프로토타입(function prototype)
// => 메서드의 이름과 파라미터 형식, 리턴 타입에 대한 정보를 말한다.


//ver 17 - 클래스 추가









