package cn.year.design.function;

/**
 * @author YearOfTheRain
 * @create 2025-01-16  11:28
 */
public class TestFunction {


    /**
      * 确认数据库字段值有效（通用）
      * 
      * @param <V> 待验证值的类型
      * @param valueToCheck 待验证的值
      * @param columnExtractor 实体类属性提取函数
      * @param queryExecutor 单条数据查询执行器
      * @param errorMessage 异常提示信息模板
      */
//    public static <T, R, V> void ensureColumnValueValid(V valueToCheck, SFunction<T, R> columnExtractor, SFunction<LambdaQueryWrapper<T>, T> queryExecutor, String errorMessage) {
//    if (valueToCheck == null) return;
//
//    LambdaQueryWrapper<T> wrapper = new LambdaQueryWrapper<>();
//    wrapper.select(columnExtractor);
//    wrapper.eq(columnExtractor, valueToCheck);
//    wrapper.last("LIMIT 1");
//
//    T entity = queryExecutor.apply(wrapper);
//    R columnValue = columnExtractor.apply(entity);
//    if (entity == null || columnValue == null)
//        throw new DataValidationException(String.format(errorMessage, valueToCheck));
//    }
    
}
