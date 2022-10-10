package com.example;

import org.json.simple.*;

public class InsertionSort {

  private static int count = 0;

  public static void main(String[] args) {
    String fileName =
      "C:/Users/redsm/Documents/GitHub/cupcake-sort-csis26/src/lovelacecupcake/src/main/java/com/example/cupcake_test_10.json";
      //"/Users/jerom/Documents/GitHub/class-java/sort/demo/src/main/java/com/sort/cupcake_3906.json";
    // v
    //
    // String fileName =
    //   "/Users/jerom/Documents/GitHub/class-java/sort/demo/src/main/java/com/sort/cupcake_10.json";

    // read cupcake names
    JSONArray cupcakeArray = JSONFile.readArray(fileName);
    String[] cupcakeNameArray = nameArray(cupcakeArray);
    System.out.println(cupcakeNameArray);

    // print unsorted list
    System.out.println("----- Unsorted array -----");
    print(cupcakeNameArray);

    // sort
    insertionSort(cupcakeNameArray);

    // print sorted list
    System.out.println("----- Sorted array----- ");
    print(cupcakeNameArray);

    // print statistics
    System.out.println("----- Statistics -----");
    System.out.printf("Size of array = %d\n", cupcakeNameArray.length);
    System.out.printf("Count = %d\n", count);
  }

  // print cupcake array
  public static void print(String[] cupcakeNameArray) {
    System.out.printf("Number\tName\n");
    System.out.printf("------\t---------------\n");
    for (int i = 0; i < cupcakeNameArray.length; i++) {
      System.out.printf("%04d\t%s\n", i, cupcakeNameArray[i]);
    }
  }

  // get array of cupcake names
  public static String[] nameArray(JSONArray cupcakeArray) {
    String[] arr = new String[cupcakeArray.size()];

    // get names from json object
    for (int i = 0; i < cupcakeArray.size(); i++) {
      JSONObject o = (JSONObject) cupcakeArray.get(i);
      String name = (String) o.get("name");
      arr[i] = name;
    }
    return arr;
  }

  // insertion sort array, O(n^2), unoptimized brute force solution
  public static void insertionSort(String[] arr) {
    // Following the assignment instructions, this code is adapted from: https://www.geeksforgeeks.org/insertion-sort/
    int L = arr.length;
    int j;
    for (int i = 1; i < L; i++) {
      String index = arr[i];
      j = i-1;
      while (j >= 0 &&  arr[j].compareTo(arr[i]) > 0)
      if (arr[j].compareTo(arr[j + 1]) > 0) {
        swap(arr, j, j + 1);
        j -= 1;
      }
      arr[j+1] = index;
    }
    // increase count
    count++;
  }

  // swap
  public static void swap(String[] arr, int a, int b) {
    String temp;
    temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
