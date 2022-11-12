/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("Tom", 'M', 37, "13912341234", "tom@126.com");
        customerList.addCustomer(customer);
    }

    /**
     * main menu
     */
    public void mainMenu() {
        while (true) {
            System.out.println("\n****客户信息管理软件****");
            System.out.println("***** 1. 添加客户 *****");
            System.out.println("***** 2. 修改客户 *****");
            System.out.println("***** 3. 删除客户 *****");
            System.out.println("***** 4. 客户列表 *****");
            System.out.println("***** 5. 退    出 *****");
            System.out.println("******请选择<1-5>******\n");

            char item = CMUtility.getMenuSelection();

            switch (item) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("提示：是否确认退出（Y/N）：");
                    char isExit = CMUtility.getConfirmSelection();
                    if (isExit== 'Y') {
                        System.exit(0);
                    } 
                    // break;
            }
        }
    }

    /**
     * start program
     * 
     * @param args the array of arguments
     */
    public static void main(String[] args) {
        CustomerView cv = new CustomerView();
        cv.mainMenu();
    }

    /**
     * Add customer.
     */
    private void addNewCustomer() {
        System.out.println("----- 客户列表 -----");
        System.out.print("姓名：");
        String name = CMUtility.getString(10);
        System.out.print("性别：");
        char gender = CMUtility.getChar('M');
        System.out.print("年龄：");
        int age = CMUtility.getInt();
        System.out.print("电话：");
        String phone = CMUtility.getString(11);
        System.out.print("邮箱：");
        String email = CMUtility.getString(20);

        Customer customer = new Customer(name, gender, age, phone, email);

        boolean isAdded = customerList.addCustomer(customer);
        if (isAdded) {
            System.out.println("提示：添加客户信息成功！");
        } else {
            System.out.println("提示：添加客户信息失败！");
        }
    }

    /**
     * Modify the information of customer.
     */
    private void modifyCustomer() {
        System.out.println("---------- 修改客户 ----------");

        Customer customer;
        int num;

        while (true) {
            System.out.println("操作：请选择修改客户编号（-1退出）：");
            
            num = CMUtility.getInt();

            if (num == -1) {
                return;
            }

            customer = customerList.getCustomer(num - 1);
            if (customer == null) {
                System.out.println("提示：无法找到指定客户！");
            } else {
                break;
            }
        }

        // 修改客户信息
        // name
        System.out.print("姓名（" + customer.getName() + ")：");
        String name = CMUtility.getString(10, customer.getName());
        // gender
        System.out.print("性别（" + customer.getGender() + ")：");
        char gender = CMUtility.getChar(customer.getGender());
        // age
        System.out.print("年龄（" + customer.getAge() + ")：");
        int age = CMUtility.getInt(customer.getAge());
        // phone
        System.out.print("电话（" + customer.getPhone() + ")：");
        String phone = CMUtility.getString(11, customer.getPhone());
        // email
        System.out.print("邮箱（" + customer.getEmail() + ")：");
        String email = CMUtility.getString(20, customer.getEmail());

        Customer newCustomer = new Customer(name, gender, age, phone, email);
        boolean isReplaced = customerList.replaceCustomer(num - 1, newCustomer);
        if (isReplaced) {
            System.out.println("提示：修改客户信息成功！");
        } else {
            System.out.println("提示：修改客户信息失败！");
        }
    }

    /**
     * Delete customer's information.
     */
    private void deleteCustomer() {
        System.out.println("---------- 客户列表 ----------");

        int num;
        while (true) {
            System.out.println("操作：请选择删除客户编号（-1退出）：");
            num = CMUtility.getInt();

            if (num == -1) {
                return;
            } 
            Customer customer = customerList.getCustomer(num - 1);
            if (customer == null) {
                System.out.println("提示：无法找到指定客户！");
            } else {
                break;
            }
        }

        // 找到指定客户，执行删除操作
        System.out.println("提示：请确认是否删除（Y/N）：");
        char isDelete = CMUtility.getConfirmSelection();
        if (isDelete == 'Y') {
            customerList.deleteCustomer(num - 1);
        }
    }

    /**
     * List the information of all customers.
     */
    private void listAllCustomers() {
        System.out.println("---------- 客户列表 ----------");
        
        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("提示：没有相关客户记录");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
            Customer[] customers = customerList.getAllCustomers();
            for (int i = 0; i < customers.length; i++) {
                System.out.println(i+1 + "\t" + customers[i].getName() + "\t" + customers[i].getGender() + "\t" 
                    + customers[i].getAge() + "\t" + customers[i].getPhone() + "\t" + customers[i].getEmail());
            }
        }
    }
}
