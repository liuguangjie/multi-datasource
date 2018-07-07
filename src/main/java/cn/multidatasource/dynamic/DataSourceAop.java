package cn.multidatasource.dynamic;

import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * @Author ms.liu
 * ~~Email 18310693623@163.com
 * @Date 2018-07-07 下午8:00
 * 动态数据源的切换 切面类
 */
public class DataSourceAop {


    public void dynamicDataSource(ProceedingJoinPoint joinPoint) {
        try {

            /**获取目标方法名称*/
            String methodName = joinPoint.getSignature()
                    .getName();
            /**获取目标*/
            Object target = joinPoint.getTarget();

            Method method = target.getClass().getMethod(methodName);
            if (method != null) {

                /**获取方法上的DataSource注解*/
                DataSource dataSource = method.getAnnotation(DataSource.class);
                if (dataSource != null) {
                    DynamicDataSourceHolder.setDataSourceType(dataSource.value());
                }
            }

            /**执行目标*/
            joinPoint.proceed();


        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            /**释放资源*/
            DynamicDataSourceHolder.clearDataSourceType();
        }
    }

}
