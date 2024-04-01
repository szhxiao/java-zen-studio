/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class TeamView {
    private NameListService nameListService = new NameListService();
    private TeamService teamService = new TeamService();

    public void mainMenu() {
        // listAllEmployees();
        while (true) {
            // 菜单列表
            System.out.println("\n*******开发团队调度管理软件*******");
            System.out.println("******* 1. 开发成员列表 *******");
            System.out.println("******* 2. 团队成员列表 *******");
            System.out.println("******* 3. 添加团队成员 *******");
            System.out.println("******* 4. 删除团队成员 *******");
            System.out.println("******* 5. 退       出 *******");

            System.out.print("请选择<1-5>: ");

            char item = TSUtility.getMenuSelection();
            switch (item) {
                case '1':
                    listAllEmployees();
                    break;
                case '2':
                    getTeam();
                    break;
                case '3':
                    addMember();
                    break;
                case '4':
                    removeMember();
                    break;
                case '5':
                    System.out.print("提示：是否确认退出（Y/N）：");
                    char isExit = TSUtility.getConfirmSelection();
                    if (isExit== 'Y') {
                        System.exit(0);
                    }
            }
        }

    }

    private void listAllEmployees() {
        System.out.println("************** 全体员工信息 **************");
        Employee[] employees = nameListService.getAllEmployees();
        if (employees == null || employees.length == 0) {
            System.out.println("提示：公司没有员工");
        } else {
            System.out.println("ID\t NAME\t AGE\t SALARY\t POSITION\t" 
                + "STATUS\t BONUS\t STOCK\t EQUIPMENT");

            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("---------------------------------------");
    }

    private void getTeam() {
        System.out.println("************** 团队成员列表 **************");
        Programmer[] team = teamService.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("提示：开发团队没有成员");
        } else {
            System.out.println("TID/ID\t NAME\t AGE\t SALARY\t POSITION\t"
                + "BONUS\t STOCK\t");

            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].toTeamString());
            }
            System.out.println("---------------------------------------");
        }
    }

    private void addMember() {
        System.out.println("************** 添加团队成员 **************");
        System.out.print("请输入要添加的员工ID: ");
        int id = TSUtility.getInt();

        try {
            Employee employee = nameListService.getEmployee(id);
            teamService.addMember(employee);
            System.out.println("提示：添加成功");
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("提示：添加失败，" + e.getMessage());
        }
        TSUtility.getReturn();
    }

    private void removeMember() {
        System.out.println("************** 删除团队成员 **************");
        System.out.print("请输入要删除的成员ID: ");
        int memberID = TSUtility.getInt();

        System.out.print("请确认是否删除(Y/N): ");
        char isRemove = TSUtility.getConfirmSelection();

        if (isRemove == 'N') {
            return;
        }

        try {
            teamService.removeMember(memberID);
            System.out.println("提示：删除成功");
        } catch (Exception e) {
            System.out.println("提示：删除失败，" + e.getMessage());
        }
        TSUtility.getReturn();
    }

    /**
     * unit test
     * 
     * @param args array of string arguments
     */
    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.mainMenu();
    }    
}
