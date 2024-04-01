/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * annotation
 */

// 1. 声明为 @interface
public @interface PrimAnnotation {
    // 2. 内部定义成员，通常用value表示
    // 可以指定成员的默认值，使用default表示；或在使用时指定值
    String value() default "prim";
}
