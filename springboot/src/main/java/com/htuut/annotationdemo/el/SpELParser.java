package com.htuut.annotationdemo.el;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * spring el 表达式解析器
 */
public class SpELParser {

    /**
     * @param key         el 表达式，占位符 # 开头
     * @param paramsNames 形参名字，可以理解为占位符名称
     * @param args        参数值，可以理解为占位符真实值
     * @return 返回 el 表达式经过参数值替换后的字符串值
     */
    public static String getKey(String key, String[] paramsNames, Object[] args) {

        ExpressionParser parser = new SpelExpressionParser();

        //将 key 字符串解析为 el 表达式
        Expression expression = parser.parseExpression(key);

        //初始化赋值上下文
        StandardEvaluationContext context = new StandardEvaluationContext();

        if (args.length <= 0) {
            return null;
        }

        //将形参和形参值以配对的方式配置到赋值上下问
        for (int i = 0; i < args.length; i++) {
            context.setVariable(paramsNames[i], args[i]);
        }

        //根据赋值上下文运算 EL 表达式
        String value = expression.getValue(context, String.class);

        return value;


    }

}
