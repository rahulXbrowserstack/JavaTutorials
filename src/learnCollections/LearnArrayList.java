package learnCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
1. Unlike a regular array, an ArrayList can grow and shrink as elements are added or removed. 
   This dynamic resizing is achieved by creating a new array and copying the elements to the new array.

2. Internally, the ArrayList is implemented as an array of Object references. 
   When you add elements to an ArrayList, you're essentially storing these elements in this internal array.

3. When you create an ArrayList, it has an initial capacity (default is 10). 
   The capacity refers to the size of the internal array that can hold elements before needing to resize.

4. When we add an element to an ArrayList, the following steps occur:
    - Check Capacity: Before adding the new element, ArrayList checks if there is enough space in the internal array (elementData). If the array is full, it needs to be resized.
    - Resize if Necessary: If the internal array is full, ArrayList creates a new array with a larger capacity (usually 1.5 times the current capacity) and copies the elements from the old array to the new array.
    - Add the Element: The new element is then added to the internal array at the appropriate index, and the size of the ArrayList is incremented.

5. Resizing the Array:
    - Initial Capacity: By default, the initial capacity is 10. This means the internal array can hold 10 elements before it needs to grow.
    - Growth Factor: When the internal array is full, a new array is created with a size 1.5 times the old array. This growth factor balances memory efficiency & resizing cost.
    - Copying Elements: When resizing occurs, all existing elements are copied from the old array to the new array, which is O(n) operation, where n is the number of elements in the ArrayList.

6. Removing Elements:
    - Check Bounds: The ArrayList first checks if the index is within the valid range.
    - Remove the Element: The element is removed, and all elements to the right of the removed element are shifted one position to the left to fill the gap.
    - Reduce Size: The size of the ArrayList is decremented by one.
 */

public class LearnArrayList {
    public static void main(String[] args) {
        /*
        ArrayList <Integer> list = new ArrayList<>(); // size = 0, capacity = 10

        ArrayList <Integer> list2 = new ArrayList<>(1000); // size = 0, capacity = 1000

        list.add(1); // 0
        list.add(5); // 1
        list.add(80); // 2

        // remove the element at index 2
        list.remove(2);

        // add 50 at index 2
        list.add(2, 50);

        // replace the element at index 2 with 50
        list.set(2, 50);

        System.out.println(list); // [1, 5, 50]

        
        System.out.println(list.get(2));
        System.out.println(list.size());

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for(int x: list) {
            System.out.println(x);
        }

        System.out.println(list.contains(5));
        System.out.println(list.contains(50));
        */

        List <String> list = new ArrayList<>();
        System.out.println(list.getClass().getName()); // java.util.ArrayList


        // returns a fixed-size List backed by the specified array, can't add or remove elements from this list, but can modify existing elements
        List <String> list1 = Arrays.asList("Monday", "Tuesday");
        System.out.println(list1.getClass().getName()); // java.util.Arrays$ArrayList
        list1.set(1, "Wednesday"); // allowed
        // list1.add("Thursday"); // throws UnsupportedOperationException


        String[] array = {"Apple", "Banana", "Cherry"};
        List <String> list2 = Arrays.asList(array);
        System.out.println(list2.getClass().getName()); // java.util.Arrays$ArrayList

        List <String> list4 = new ArrayList<>(list2); // creates a new ArrayList with the elements of list2, this list is modifiable
        list4.add("Mango");
        System.out.println(list4);


        List <Integer> list3 = List.of(1, 2, 3); // return unmodifiable list, can't add, remove or modify elements
        // list3.set(1, 33); // throws UnsupportedOperationException



        List <Integer> list5 = new ArrayList<>();
        list5.add(1);
        list5.add(2);
        list5.add(3);
        list5.add(0, 0);

        List <Integer> list6 = List.of(4, 5, 6, 7, 8, 9);

        list5.addAll(list6);
        System.out.println(list5); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]




        List <Integer> list7 = new ArrayList<>();
        list7.add(1);
        list7.add(2);
        list7.add(3);

        // list7.remove(1); // removes the element at index 1, which is 2
        list7.remove(Integer.valueOf(1)); // removes the object 1, which is at index 0 after the previous removals
        System.out.println(list7); // [2, 3]


        Collections.sort(list7); // sorts the list in natural order
        list7.sort(null); // sorts the list in natural order, same as Collections.sort(list7)


        Object[] array1 = list7.toArray();
        Integer[] array2 = list7.toArray(new Integer[0]);
        

        List <String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Banana");
        fruits.add("Date");

        fruits.remove("Apple"); // removes the object "Apple", only the first occurrence is removed

        System.out.println(fruits); // [Apple, Banana, Cherry, Banana, Date]
    }
}