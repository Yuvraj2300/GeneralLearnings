package lrn.collection.comparator;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class TComp implements Comparator<String> {
	public int compare(String aStr, String bStr) {
		int i, j, k;
// Find index of beginning of last name.
		i = aStr.lastIndexOf(' ');
		j = bStr.lastIndexOf(' ');
		k = aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
		if (k == 0) // last names match, check entire name
			return aStr.compareToIgnoreCase(bStr);
		else
			return k;
	}
// No need to override equals.
}

public class TreeMapDemo {

	public static void main(String[] args) {
		TreeMap<String, Double> tm_us = new TreeMap<>();
		TreeMap<String, Double> tm = new TreeMap<String, Double>(new TComp());

		tm_us.put("John Doe", new Double(43456.65));
		tm_us.put("Ron White", new Double(8765.98));
		tm_us.put("Jane Baker", new Double(1378.00));
		tm_us.put("Tod Hall", new Double(99.22));
		tm_us.put("Ralph Smith", new Double(-19.08));

		tm.put("John Doe", new Double(3434.34));
		tm.put("Tom Smith", new Double(123.22));
		tm.put("Jane Baker", new Double(1378.00));
		tm.put("Tod Hall", new Double(99.22));
		tm.put("Ralph Smith", new Double(-19.08));
		//

		System.out.println("Values in the normal comparator Tree Set");
		Set<Map.Entry<String, Double>> nset = tm_us.entrySet();
		nset.forEach(me -> {
			System.out.print(me.getKey() + " : ");
			System.out.println(me.getValue());
		});

		System.out.println();

		System.out.println("Values in the custom comparator Tree Set");
		Set<Map.Entry<String, Double>> set = tm.entrySet();
		set.forEach(m -> {
			System.out.print(m.getKey() + " : ");
			System.out.println(m.getValue());
		});

		System.out.println();

		double balance = tm.get("John Doe");
		tm.put("John Doe", balance + 1000);

		System.out.println("New Balance for John Doe is : " + tm.get("John Doe"));
	}

}
