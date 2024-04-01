/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Scanner;

/**
 * 
 */
public class ExamStudentTest {
    public static void insert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("四级/六级：");
        int type = scanner.nextInt();
        System.out.print("身份证号：");
        String idCard = scanner.next();
        System.out.print("准考证号：");
        String examCard = scanner.next();
        System.out.print("学生姓名：");
        String name = scanner.next();
        System.out.print("所在城市：");
        String location = scanner.next();
        System.out.print("考试成绩：");
        int grade = scanner.nextInt();

        String sql_insert = "INSERT INTO `examstudent` (`Type`,`IDCard`,`ExamCard`,`StudentName`,`Location`,`Grade`) VALUES (?,?,?,?,?,?)";
        int insertCount = update(sql_insert, type, idCard, examCard, name, location, grade);
        if (insertCount > 0) {
            System.out.println("提示：添加成功！");
        } else {
            System.out.println("提示：添加失败");
        }
    }

    public static void queryWithIDCardOrExamCard() {
        System.out.println("提示：请选择您要输入的类型");
        System.out.println("a.准考证号");
        System.out.println("b.身份证号");
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.next();

        if ("a".equalsIgnoreCase(selection)) {
            System.out.print("请输入准考证号：");
            String examCard = scanner.next();

            String sql_query = "SELECT FlowID id,Type type, IDCard idCard,ExamCard examCard," +
                    "StudentName name,Location location,Grade grade FROM examstudent WHERE examCard = ?";
            Student student = getInstance(Student.class, sql_query, examCard);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("提示：输入有误！");
            }
        } else if ("b".equalsIgnoreCase(selection)) {
            System.out.print("请输入身份证号：");
            String idCard = scanner.next();

            String sql_query = "SELECT FlowID id,Type type, IDCard idCard,ExamCard examCard," +
                    "StudentName name,Location location,Grade grade FROM examstudent WHERE idCard = ?";
            Student student = getInstance(Student.class, sql_query, idCard);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("提示：输入有误！");
            }
        } else {
            System.out.println("提示：输入错误，请重新进入程序");
        }
    }

    public static void delete() {
        System.out.print("请输入准考证号：");
        Scanner scanner = new Scanner(System.in);
        String examCard = scanner.next();
//        String sql_query = "SELECT FlowID id,Type type, IDCard idCard,ExamCard examCard," +
//                "StudentName name,Location location,Grade grade FROM examstudent WHERE examCard = ?";
//        Student student = getInstance(Student.class, sql_query, examCard);
//        if (student == null) {
//            System.out.println("提示：查无此人，请重新输入！");
//        } else {
//            String sql_delete = "DELETE FROM examstudent WHERE ExamCard = ?";
//            int deleteCount = update(sql_delete, examCard);
//            if (deleteCount > 0) {
//                System.out.println("提示：删除成功！");
//            } else {
//                System.out.println("提示：查无此人，请重新输入！");
//            }
//        }
        String sql_delete = "DELETE FROM examstudent WHERE ExamCard = ?";
        int deleteCount = update(sql_delete, examCard);
        if (deleteCount > 0) {
            System.out.println("提示：删除成功！");
        } else {
            System.out.println("提示：查无此人，请重新输入！");
        }
    }

    /**
     * 通用增删改操作
     *
     * @param sql 预编译SQL语句
     * @param args 可变参数列表
     */
    public static int update(String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. 获取数据库连接
            conn = JDBCUtils.getConnection();
            // 2. 预编译sql语句
            ps = conn.prepareStatement(sql);
            // 3. 填充占位符，占位符个数等于可变形参个数
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            // 4. 执行操作
//            ps.execute();
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            JDBCUtils.closeResource(conn, ps);
        }
        return 0;
    }

    /**
     * 查询返回一条记录
     *
     * @param clazz 对象类
     * @param sql 预编译SQL语句
     * @param args 可变参数
     * @param <T> 类型
     * @return 一个对象
     */
    public static <T> T getInstance(Class<T> clazz, String sql, Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            // 填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            // 获取结果集
            rs = ps.executeQuery();

            // 获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                // 处理一行数据中的每一列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnValue = rs.getObject(i+1);
                    // 获取列别名
                    String columnLabel = rsmd.getColumnLabel(i+1);

                    // 每个属性赋值
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);

                }
                return t;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }
    
    public static void main(String[] args) {
        insert();
        queryWithIDCardOrExamCard();
        delete();
    }
}
