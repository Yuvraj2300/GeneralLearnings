package com.test.util;

import java.util.List;

import com.test.pojo.Product;

@FunctionalInterface
public interface MyFunc {
	List<Product> func();
}
