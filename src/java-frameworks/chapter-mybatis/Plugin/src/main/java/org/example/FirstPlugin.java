/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

// 进行插件签名
@Intercepts({
        @Signature(type = StatementHandler.class,
                method = "parameterize", args = java.sql.Statement.class)
})
public class FirstPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("FirstPlugin --> intercept");
        // 执行目标方法
        Object proceed = invocation.proceed();
        return proceed;
    }

    /**
     * 包装目标对象，即为目标对象创建一个代理对象
     *
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        System.out.println("FirstPlugin --> plugin");
        Object wrap = Plugin.wrap(target, this);
        return  wrap;
    }

    /**
     * 将插件注册时的property复制进来
     *
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("FirstPlugin --> setProperties");
        System.out.println("插件配置信息：" + properties);
    }
}
