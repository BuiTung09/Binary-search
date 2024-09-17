package binarysearch;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {

    public static Scanner sc = new Scanner(System.in);

    public static int nhapVao(String mess, int min, int max) {
        while (true) {
            System.out.println(mess);
            try {
                int n = sc.nextInt();
                if (min <= n && n <= max) {
                    return n;
                } else {
                    System.err.println("Out of range");
                }
            } catch (InputMismatchException ex) {
                System.err.println("Wrong format");
                sc.next(); // xóa dữ liệu trong Scanner để tránh lặp vô hạn 
            }
        }
    }

    public static int[] randomSortedArray(int n, int max) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            a[i] = random.nextInt(max);
        }
        Arrays.sort(a);
        return a;
    }

    public static void display(int[] a) {
        System.out.print("Sorted Array: [");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int numbOfArr = nhapVao("Enter nummber of array: ", 1, Integer.MAX_VALUE);
        int searchValue = nhapVao("Enter search value: ", 1, Integer.MAX_VALUE);
        int[] Arr = randomSortedArray(numbOfArr, numbOfArr);
        display(Arr);

        int index = binarySearch(Arr, searchValue);
        if (index == -1) {
            System.out.println("\nNot found\n");
        } else {
            System.out.println("\nFound" + searchValue + " at index: " + index + "\n");
        }
    }

}
