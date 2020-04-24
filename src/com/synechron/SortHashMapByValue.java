package com.synechron;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortHashMapByValue {

	public void sortByValue(LinkedHashMap<Integer, String> map) {

		List<Map.Entry<Integer, String>> list = new LinkedList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {

			@Override
			public int compare(Entry<Integer, String> arg0, Entry<Integer, String> arg1) {
				return arg0.getValue().compareTo(arg1.getValue());
			}
		});

		LinkedHashMap<Integer, String> temp = new LinkedHashMap<>();

		for (Map.Entry<Integer, String> entry : list) {
			temp.put(entry.getKey(), entry.getValue());
		}

		System.out.println("sorting map by java7=" + temp);

	}

	public static void main(String[] args) {
		SortHashMapByValue sortHashMapByValue = new SortHashMapByValue();

		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		map.put(1, "Priyanka");
		map.put(2, "Adinath");
		map.put(3, "Komal");
		map.put(4, "Amrita");
		map.put(5, "Suchita");

		// using java7
		sortHashMapByValue.sortByValue(map);

		// using java8
		sortHashMapByValue.sortByValueTechnique(map);
	}

	public void sortByValueTechnique(LinkedHashMap<Integer, String> map) {

		Map<Integer, String> sortedIdNameMap = map.entrySet().stream().sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println("sorting map by java8=" + sortedIdNameMap);
	}

}
