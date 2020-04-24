package com.synechron;

import java.util.Arrays;

public final class MyString {

	private final char[] data;

	public MyString(char[] data) {
		super();
		this.data = Arrays.copyOf(data, data.length);
	}

	public char charAt(int index) {

		if (index < data.length) {
			return data[index];
		} else {
			throw new StringIndexOutOfBoundsException("Invalid index.");
		}

	}

	public int indexOf(char element) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == element) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(char element) {
		for (int i = data.length - 1; i >= 0; i--) {
			if (data[i] == element) {
				return i;
			}
		}
		return -1;
	}

	public char[] concat(MyString string2) {
		int length = data.length;

		int newLength = data.length + string2.data.length;

		char[] newData = Arrays.copyOf(data, newLength + 1);

		int j = 0;
		for (int i = length; i < newData.length && j < string2.data.length; i++) {
			newData[i] = string2.data[j++];
		}

		return newData;
	}

	public int length() {
		return data.length;
	}

	public static void main(String[] args) {

		char[] data = { 'P', 'r', 'i', 'y', 'a', 'n', 'k', 'a' };
		char[] data1 = { 'A', 'd', 'a', 'm', 'u', 't', 'h', 'e' };

		String str = new String("Priyanka");

		MyString string1 = new MyString(data);
		MyString string2 = new MyString(data1);

		// concat() method
		System.out.print("concat method=");
		for (char i : string1.concat(string2)) {
			System.out.print(i);
		}
		System.out.println("");

		// charAt() method
		System.out.println("character at index 3=" + string1.charAt(3));

		// indexOf() method
		System.out.println("indexOf a=" + string1.indexOf('a'));

		// lastIndexOf() method
		System.out.println("lastIndexof a=" + string1.lastIndexOf('a'));

		// length() method
		System.out.println("length=" + string1.length());

	}

}
