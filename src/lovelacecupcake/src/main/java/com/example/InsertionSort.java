package com.example;

import org.json.simple.*;

public class InsertionSort {

  private static int count = 0;

  public static void main(String[] args) {
    String fileName =
      "C:/Users/redsm/Documents/GitHub/cupcake-sort-csis26/src/lovelacecupcake/src/main/java/com/example/cupcake_3906.json";
      // This file path is intended for my computer
      // The user of this program may need to modify
      // the above file path so that the program will
      // work on their computer.
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

  // insertion sort method 
  public static void insertionSort(String[] arr) {
    // Following the assignment instructions, this
    // code is adapted from: 
    // https://www.geeksforgeeks.org/insertion-sort/
    int L = arr.length;
    int j;
    String index;
    // We define these variables up here 
    // so that we don't have to redeclare
    // the variable every time we want to
    // change its value.
    for (int i = 1; i < L; i++) {
      index = arr[i];
      j = i-1;
      while (j >= 0 &&  arr[j].compareTo(index) > 0) {
        arr[j+1] = arr[j];
        j -= 1;
        // increase count 
        // (the counter is useful for measuring 
        // the efficiency of the program)
        count++; 
      }
      arr[j+1] = index;
    }
  }

  // swap
  public static void swap(String[] arr, int a, int b) {
    String temp;
    temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
