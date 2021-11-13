/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 家庭收支记录软件V0.1
 */
public class FamilyAccount {
    /**
     * main()
     * 
     * @param args array of string arguments
     */
    public static void main(String[] args) {
        // 记录用户收支信息
        String details = "";
        // 账户初始额
        int balance = 10000;

        while (true) {
            System.out.println("\n******家庭收支记账******");
            System.out.println("***** 1. 收支明细 *****");
            System.out.println("***** 2. 记录收入 *****");
            System.out.println("***** 3. 记录支出 *****");
            System.out.println("***** 4. 退    出 *****");
            System.out.println("******请选择<1-4>******\n");
        
            // 用户选择
            char item = Utility.getMenuSelection();

            switch (item) {
                case '1':
                    System.out.println("----- 当前收支明细记录 -----");
                    System.out.println("收支\t账户金额\t收支金额\t说明");
                    System.out.println(details);
                    System.out.println("-------------------------");
                    break;
                case '2':
                    System.out.print("本次收入金额：");
                    int income = Utility.getMoney();
                    balance += income;
                    System.out.print("本次收入说明：");
                    String incomeInfo = Utility.getString();
                    details += ("收入\t " + balance + "\t\t" + "+" + income + "\t\t" + incomeInfo + "\n");
                    System.out.println("------- 收入记录完成 -------\n");
                    break;
                case '3':
                    System.out.print("本次支出金额：");
                    int expenditure = Utility.getMoney();
                    if (balance >= expenditure) {
                        balance -= expenditure;
                    } else {
                        System.out.println("支出超出额度，支付失败");
                    }
                    System.out.print("本次支出说明：");
                    String expenditureInfo = Utility.getString();
                    details += ("支出\t " + balance + "\t\t" + "-" + expenditure + "\t\t" + expenditureInfo + "\n");
                    System.out.println("------- 支出记录完成 -------\n");
                    break;
                case '4':
                    System.out.println("确认是否退出");
                    char selection = Utility.getConfirmSelection();
                    if (selection == 'Y') {
                        System.exit(0);
                    } 
                }
            }
    }    

    
}
