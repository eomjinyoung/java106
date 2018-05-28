package jsp;

public class Team {
    String name;
    String description;
    Member[] members;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Member[] getMembers() {
        return members;
    }
    public void setMembers(Member[] members) {
        this.members = members;
    }
    
    
}
