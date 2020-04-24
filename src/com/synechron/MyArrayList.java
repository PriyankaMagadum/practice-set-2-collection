package com.synechron;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList {

	private Object[] arr;
	private int actSize;

	public MyArrayList() {
		super();
		arr = new Object[10];
		this.actSize = 0;
	}

	public boolean add(Object element) {

		if (actSize <= arr.length - 5) {
			increaseArraySize();
		}

		arr[actSize++] = element;

		return true;
	}

	public Object get(int index) {

		if (index <= actSize) {
			return arr[index];
		} else {
			throw new ArrayIndexOutOfBoundsException("Invalid index.");
		}

	}

	public void increaseArraySize() {

		Arrays.copyOf(arr, arr.length + 10);

	}

	public Object remove(int index) {
		if (index <= actSize) {

			Object object = arr[index];

			while (index <= actSize) {
				arr[index] = arr[index + 1];
				arr[index + 1] = null;
				index++;
			}

			actSize--;
			return object;
		} else {
			throw new ArrayIndexOutOfBoundsException("Invalid index.");
		}
	}

	public int size() {
		return actSize;
	}

	public static void main(String[] args) {

		MyArrayList myArrayList = new MyArrayList();

		myArrayList.add(10);
		myArrayList.add(20);
		myArrayList.add(30);
		myArrayList.add(40);
		myArrayList.add(50);
		myArrayList.add(60);

		System.out.println("value at index 1=" + myArrayList.get(1));
		System.out.println("removed object value at index 5=" + myArrayList.remove(3));

		for (int i = 0; i < myArrayList.size(); i++) {
			System.out.print(myArrayList.get(i) + ",");
		}

	}

}
