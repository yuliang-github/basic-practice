package com.yl.leetcode.algorithm.A20;

import java.util.Stack;

/**
 * @author yu.alex
 * @date 2019/6/27 15:31
 * @des
 */
public class BracketMatch {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     */
    public static boolean bracketMatch(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                Character item = stack.pop();
                if(!(
                    (item == '(' && c == ')')
                            || (item == '[' && c == ']')
                            || (item == '{' && c == '}')
                        )){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.err.println(bracketMatch("({]})"));

    }
}
