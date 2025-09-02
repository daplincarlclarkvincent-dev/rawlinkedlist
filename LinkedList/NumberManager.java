/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestJave;

/**
 *
 * @author carlc
 */


public class NumberManager {
    private int[] numbers;
    private int size;

    public NumberManager() {
        numbers = new int[2];
        size = 0;
    }

    public void add(int x) {
        if (size == numbers.length) {
            resize();
        }
        numbers[size++] = x;
        System.out.println(x + " added.");
    }

    private void resize() {
        int newCapacity = numbers.length * 2;
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < numbers.length; i++) {
            newArray[i] = numbers[i];
        }
        numbers = newArray;
    }

    public boolean delete(int x) {
        for (int i = 0; i < size; i++) {
            if (numbers[i] == x) {
                for (int j = i; j < size - 1; j++) {
                    numbers[j] = numbers[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public void clear() {
        size = 0;
        System.out.println("All numbers cleared.");
    }

    public void display() {
        if (size == 0) {
            System.out.println("List is empty.");
        } else {
            System.out.print("Numbers: ");
            for (int i = 0; i < size; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        return size == 0 ? -1 : numbers[0]; // or throw exception
    }

}
