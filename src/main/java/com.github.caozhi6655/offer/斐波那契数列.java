package com.github.caozhi6655.offer;

/**
 * @Description
 * @Author ht
 * @Date 2019/8/1 20:39
 */
public class 斐波那契数列 {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }
}
