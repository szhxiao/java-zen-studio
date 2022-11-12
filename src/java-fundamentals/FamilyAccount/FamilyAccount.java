/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * The first program HelloWorld
 */
public class FamilyAccount {
    /**
     * main()
     * 
     * @param args array of string arguments
     */
    public static void main(String[] args) {
        FamilyAccount familyAccount = new FamilyAccount();
        familyAccount.start();
    }    

    public void start() {
        OperatorRegex regex = new OperatorRegex();
        Operate operate = new Operate();
        while (true) {
            Menu.mainMenu();
            int item = regex.validateMenuItem(1, 4);
            switch (item) {
                case 1:
                    operate.listDetails();
                    break;
                case 2:
                    operate.recordIncome();
                    break;
                case 3:
                    operate.recordExpenditure();
                    break;
                case 4:
                    operate.exit();
                    break;
            }
        }
    }
}
