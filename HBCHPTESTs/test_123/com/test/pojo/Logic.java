package com.test.pojo;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Logic implements BiPredicate<Product, MatchingCriteria>{

	@Override
	public boolean test(Product t, MatchingCriteria u) {
		t.test(t)
		
		return false
	}
	/*static List<Product> match(List<Product> products, List<MatchingCriteria> matchingCriterias) {
		return null;
	}*/

}
