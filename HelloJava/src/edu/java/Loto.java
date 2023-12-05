package edu.java;

import java.util.Scanner;
import java.util.Arrays;

public class Loto {

	public static void main(String[] args) throws Exception {

		int[] lotoA = new int[7]; // lotoA 배열 선언

		for (int i = 0; i < 7; i++) {

			int random = (int) (Math.random() * 45) + 1;
			lotoA[i] = random;

			for (int j = 0; j < 7; j++) {

				if (lotoA[j] == random) {

					i = j;
					break;

				}

			}

		} // lotoA 배열 값 지정

		System.out.println(Arrays.toString(lotoA)); // lotoA 값 확인 용

		Scanner scanner = new Scanner(System.in);
		String rowInputData;
		int[] inputDataA = new int[6];

		for (int i = 0; i < 6; i++) {

			rowInputData = scanner.nextLine();
			int inputData = Integer.parseInt(rowInputData);
			inputDataA[i] = inputData;

		}

		int count = 0;
		int count2 = 0;

		for (int i = 0; i < 6; i++) {

			for (int j = 0; j < 6; j++) {

				if (inputDataA[i] == lotoA[j]) {

					count = count + 1;

				} else {

					continue;

				}

			}

			if (inputDataA[i] == lotoA[6]) {

				count2 = 1;

			}

		}

		switch (count) {

		case 1:
			System.out.println("꽝~!");
			break;

		case 2:
			System.out.println("꽝~!");
			break;

		case 3:
			System.out.println("5등");
			break;

		case 4:
			System.out.println("4등");
			break;

		case 5:
			if (count2 == 1) {
				System.out.println("2등");
			} else {
				System.out.println("3등");
			}
			break;

		case 6:
			System.out.println("1등");
			break;
		}

	} // main

} // class