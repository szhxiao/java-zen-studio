/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package pojo;

public class Order {
    private String oname;

    public Order() {
        System.out.println("步骤1：执行无参构造器创建Bean实例");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("步骤2：调用属性set方法设置对应值");
    }

    //创建执行的初始化方法
    public void init() {
        System.out.println("步骤3：执行初始化方法");
    }

    //创建执行的销毁方法
    public void destroy() {
        System.out.println("步骤5：执行销毁方法");
    }
}
