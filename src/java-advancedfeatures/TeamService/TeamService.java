/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class TeamService {

    private static int counter = 1; // memberID
    private int MAX_MEMBER = 5; // 开发团队人数
    private Programmer[] team = new Programmer[MAX_MEMBER]; // 保存开发团队成员
    private int total;  // 开发团队实际人数

    public TeamService() {

    }

    public Programmer[] getTeam() {
        Programmer[] temp = new Programmer[total];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = this.team[i];
        }
        return temp;
    }

    public void addMember(Employee e) throws TeamException {
        // 团队成员已满
        if (total >= MAX_MEMBER) {
            throw new TeamException("异常：团队已满，无法添加");
        }

        // 成员类型不匹配
        if (!(e instanceof Programmer)) {
            throw new TeamException("异常：成员不是开发人员，无法添加");
        }

        // 成员已添加至团队
        if (isExist(e)) {
            throw new TeamException("异常：成员已添加至团队，无法重复添加");
        }

        // 
        Programmer programmer = (Programmer) e;
        // if ("BUSY".equals(programmer.getStatus().getNAME())) {
        //     throw new TeamException("异常：成员已添加至团队，无法重复添加");
        // } else if ("VOCATION".equalsIgnoreCase(programmer.getStatus().getName())) {
        //     throw new TeamException("异常：成员正在休假，无法添加");
        // }

        switch (programmer.getStatus()) {
            case BUSY:
                throw new TeamException("异常：成员已添加至团队，无法重复添加");
            case VOCATION:
                throw new TeamException("异常：成员正在休假，无法添加");
        }


        // 团队中最多有一名架构师、二名设计师、三名程序员
        int numOfArchitect = 0;
        int numOfDesigner = 0;
        int numOfProgrammer = 0;

        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArchitect++;
            } else if (team[i] instanceof Designer) {
                numOfDesigner++;
            } else if (team[i] instanceof Programmer) {
                numOfProgrammer++;
            }
        }

        if (programmer instanceof Architect) {
            if (numOfArchitect >= 1) {
                throw new TeamException("异常：团队中最多有一名架构师");
            }
        } else if (programmer instanceof Designer) {
            if (numOfDesigner >= 2) {
                throw new TeamException("异常：团队中最多有二名设计师");
            }
        } else if (programmer instanceof Programmer) {
            if (numOfProgrammer >= 3) {
                throw new TeamException("异常：团队中最多有三名程序员");
            }
        }

        // 添加成员至团队
        team[total] = programmer;
        total++;

        // 修改成员属性
        programmer.setStatus(Status.BUSY);
        programmer.setMemberId(counter);
        counter++;
    }

    /**
     * 判断成员指定成员是否在团队中
     * 
     * @param e
     * @return
     */
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberID) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == memberID) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        // 未找到指定元素
        if (i == total) {
            throw new TeamException("异常：未发现指定成员");
        }

        // 后一元素覆盖前一元素
        for (int j = i; j < total-1; j++) {
            team[j] = team[j+1];
        }
        team[total-1] = null;
        total--;

    }

    /**
     * unittest
     * 
     * @param args array of string arguments
     */
    public static void main(String[] args) {
        
    }    
}
