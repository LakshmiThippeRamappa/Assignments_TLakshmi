package com.seven.one;
import java.util.Arrays;
import java.util.Scanner;

/*
 7.1 : Write a program to store product names in a string array and sort strings available in an
array.
 */
public class ProductSorter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        String[] products = new String[n];

        
        System.out.println("Enter product names:");
        for (int i = 0; i < n; i++) {
            System.out.print("Product " + (i + 1) + ": ");
            products[i] = sc.nextLine();
        }

        Arrays.sort(products);

        System.out.println("\nSorted Product Names:");
        for (String product : products) {
            System.out.println(product);
        }

        sc.close();
    }
}

/*
Enter number of products: 3
Enter product names:
Product 1: lap
Product 2: bucket
Product 3: gadjet
*/