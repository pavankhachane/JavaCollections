package com.pavan;

import java.util.*;

public class PracticeHashSet {

    private static Scanner scanner = new Scanner(System.in);
    private static List<String> areaList;

    public static void main(String[] args) {
        // write your code here
        boolean quit = false;
        int choice = 0;
        printInstructions();

        while (!quit) {
            System.out.println();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    initializeDefaultList();
                    break;
                case 2:
                    customSetObjects();
                    break;
                case 3:
                    sortCustomSetObjects();
                    break;
                case 4:
                    compareCustomSetObjects();
                    break;
                case 5:
                    performSetOperations();
                    break;
                case 6:
                    createTreeSet();
                    break;
                case 7:
                    createLinkedHashSet();
                    break;
                case 10:
                    quit = true;
                    break;
                default:
                    System.out.println("Illegal Input");
                    break;
            }
        }

    }

    private static void createLinkedHashSet() {
        StringBuilder stringBuilder = new StringBuilder();

        String[] stringArray = {"foo", "bar", "baz", "foo", "bar", "baz", "Hinjawadi", "Bhugaon", "Magarpatta",
                "Hinjawadi", "Shivaji Nagar", "Wakad", "Hadapsar", "Hinjawadi", "Balewadi High Street", "Yerawada", "Bavdhan",
                "Kalyani Nagar", "Baner", "Koregaon Park", "Pimple Saudagar", null, null};

        List<String> areaList = new ArrayList<>(Arrays.asList(stringArray));
        System.out.println("ArrayList Size : " + areaList.size());

        Set<String> stringsLinkedHashSet = new LinkedHashSet<>(areaList);
        System.out.println("stringsLinkedHashSet Size : " + stringsLinkedHashSet.size());

        stringsLinkedHashSet.forEach(System.out::println);

        Set<Integer> integerSet = new LinkedHashSet<>();
        integerSet.add(1);
        integerSet.add(3);
        integerSet.add(2);
        integerSet.add(null);
        integerSet.add(0);
        integerSet.add(null);

        integerSet.forEach(System.out::println);

        integerSet.remove(0);
    }

    private static void createTreeSet() {

        Set<Integer> integerSet = new TreeSet<>();
        integerSet.add(1);
        integerSet.add(0);
        integerSet.add(100);
        integerSet.add(45);
        integerSet.add(17);
        integerSet.add(100);
        integerSet.remove(17);

        System.out.println("Integer TreeSet : => " + integerSet); // Integer TreeSet : => [0, 1, 17, 45, 100]
        System.out.println();

        Set<String> stringSet = new TreeSet<>();
        stringSet.add("Pavan");
        stringSet.add("pavan");
        stringSet.add("Vinayak");
        stringSet.add("alok");
        stringSet.add("Ankit");
        stringSet.add("Satyam");
        stringSet.add("Saurabh");
        System.out.println(" By Default any sort of Lower Case and Upper Case strings are not sorted properly in java");
        System.out.println("TreeSet of Strings : => " + stringSet);

        //TreeSet of Strings : => [Ankit, Pavan, Satyam, Saurabh, Vinayak, alok, pavan]

        System.out.println("==================== TreeSet of Custom Objects===========================");

        Set<Employee> employees = new TreeSet<>();
        Employee e1 = new Employee(1234, 75000, "PAVAN", "khachane");
        Employee e2 = new Employee(4050, 12545, "Ankit", "Chilkalwar");
        Employee e3 = new Employee(1804, 25000, "Saurabh", "Brahmankar");
        Employee e4 = new Employee(2002, 85000, "Satyam", "Wakekar");
        Employee e5 = new Employee(1945, 80000, "Vinayak", "Lokhande");
        Employee e6 = new Employee(1804, 25000, "Saurabh", "Brahmankar");
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);

        System.out.println(employees);

        System.out.println();

        Set<Pen> pens = new TreeSet<>();
        Pen p1 = new Pen(10, "Blue");
        Pen p2 = new Pen(20, "Red");
        Pen p3 = new Pen(5, "Brown");
        Pen p4 = new Pen(15, "Green");
        Pen p5 = new Pen(10, "Blue");

        pens.add(p1);
        pens.add(p2);
        pens.add(p3);
        pens.add(p4);
        pens.add(p5);

        System.out.println("For using TreeSet we need to compulsory Implement Comparable Interface to Custom Objects");
        System.out.println("Without overrding HashCode and Equals and ToString");
        System.out.println(pens);
        // [com.pavan.Pen@6d6f6e28, com.pavan.Pen@135fbaa4, com.pavan.Pen@45ee12a7, com.pavan.Pen@330bedb4, com.pavan.Pen@2503dbd3]

        System.out.println("Only implementing Comparable will not ony prevent CastClassException to occur. " +
                "But inorder to sort TreeSet we have to override equals and which will compa    re objects and will sort TreeSet");





    }

    private static void performSetOperations() {
        Integer[] A = {22, 45, 33, 66, 55, 34, 77};
        Integer[] B = {33, 2, 83, 45, 3, 12, 55};

        Set<Integer> set1 = new HashSet<>(Arrays.asList(A));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(B));

        System.out.println("Size = " + set1.size() + " " + set1); // Size = 7 [33, 66, 34, 22, 55, 45, 77]
        System.out.println("Size = " + set2.size() + " " + set2); // Size = 7 [33, 2, 83, 3, 55, 12, 45]

        // Finding Union of set1 and set2
        System.out.println("Union of set1 and set2 : Combine all elements from set 1 and set 2 and avoid duplicates");

        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        System.out.println("Size of Union Set : " + unionSet.size() + " " + unionSet);

        //Union of set1 and set2 : Combine all elements from set 1 and set 2 and avoid duplicates
        //Size of Union Set : 11 [33, 66, 34, 2, 83, 3, 22, 55, 12, 45, 77]

        // Finding Intersection of set1 and set2
        System.out.println("Intersection of set1 and set2 : Find Common elements from set 1 and set 2 and avoid duplicates");

        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        System.out.println("Size of Union Set : " + intersectionSet.size() + " " + intersectionSet);

        //Intersection of set1 and set2 : Find Common elements from set 1 and set 2 and avoid duplicates
        //Size of Union Set : 3 [33, 55, 45]

        // Finding Difference of set1 and set2
        Set<Integer> difference_data = new HashSet<Integer>(set1);
        difference_data.removeAll(set2);
        System.out.print("Difference of set1 and set2 is:");
        System.out.println(difference_data);

        //Difference of set1 and set2 is:[66, 34, 22, 77]
    }

    private static void compareCustomSetObjects() {

        List<String> list1 = new LinkedList<>(Arrays.asList("foo", "bar", "baz", "foo", "bar", "baz", "Hinjawadi",
                "Magarpatta", "Hinjawadi",  "Wakad", "Hadapsar", "BalewadiHighStreet", "Baner"));

        List<String> list2 = new LinkedList<>(Arrays.asList("foo", "bar", "baz", "foo", "bar", "baz", "Hinjawadi",
                "Magarpatta", "Hinjawadi",  "Wakad", "Hadapsar", "BalewadiHighStreet", "Baner"));

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.addAll(list1);
        set2.addAll(list2);

        System.out.println(set1);
        System.out.println(set2);
        System.out.println("set1.equals(set2) => " + set1.equals(set2));

        System.out.println("set == set2  => " + (set1 == set2));

        Employee e1 = new Employee(1234, 75000, "pavan", "khachane");
        Employee e8 = new Employee(1001, 9999999, "xyz", "M");
        Employee e2 = new Employee(1234, 75000, "Pavan", "Khachane");
        Employee e3 = new Employee(2081, 50000, "Prasanna", "Phirke");
        Set<Employee> employeeSet1 = new HashSet<>();
        employeeSet1.add(e1);
        employeeSet1.add(e8);
        employeeSet1.add(e2);
        employeeSet1.add(e3);

        /*Employee e4 = new Employee(4567, 999999, "Satyam", "Wakekar");
        Employee e5 = new Employee(1234, 75000, "Pavan", "K");
        Employee e6 = new Employee(1000, 9999999, "Sameer", "M");
        Employee e7 = new Employee(1002, 9999999, "abCD", "M");*/

        Employee b1 = new Employee(1234, 75000, "PAVAN", "khachane");
        Employee b2 = new Employee(1001, 9999999, "XYZ", "M");
        Employee b3 = new Employee(1234, 75000, "Pavan", "Khachane");
        Employee b4 = new Employee(2081, 50000, "prasanna", "Phirke");

        Set<Employee> employeeSet2 = new HashSet<>();
        employeeSet2.add(b1);
        employeeSet2.add(b2);
        employeeSet2.add(b3);
        employeeSet2.add(b4);

        System.out.println();
        System.out.println("==================Custom Obj Set =================================");
        System.out.println(employeeSet1);
        System.out.println(employeeSet2);
        System.out.println("set1.equals(set2) => " + employeeSet1.equals(employeeSet2));

        System.out.println("set == set2  => " + (employeeSet1 == employeeSet2));

    }

    private static void sortCustomSetObjects() {
        Employee e1 = new Employee(1234, 75000, "pavan", "khachane");
        Employee e8 = new Employee(1001, 9999999, "xyz", "M");
        Employee e2 = new Employee(1234, 75000, "Pavan", "Khachane");
        Employee e3 = new Employee(2081, 50000, "Prasanna", "Phirke");
        Employee e4 = new Employee(4567, 999999, "Satyam", "Wakekar");
        Employee e5 = new Employee(1234, 75000, "Pavan", "K");
        Employee e6 = new Employee(1000, 9999999, "Sameer", "M");
        Employee e7 = new Employee(1002, 9999999, "abCD", "M");

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(e1);
        employeeSet.add(e8);
        employeeSet.add(e2);
        employeeSet.add(e3);
        employeeSet.add(e4);
        employeeSet.add(e5);
        employeeSet.add(e6);
        employeeSet.add(e7);
        System.out.println("HashSet without Comparable/Comparator");
        System.out.println(employeeSet);
        // Cant use  Collection.sort because is supports List in input not set
        // Collections.sort(employeeSet);  -> gives error

        // Convert to List and then sort
        List<Employee> employeeList = new ArrayList<>(employeeSet);
        // Collections.sort(employeeList);   // Default Sort using firstName
        Collections.sort(employeeList,new EmployeeComparatorByID());

        System.out.println();
        System.out.println("HashSet with Comparable : Sort by Employee.id");
        System.out.println(employeeList);

        System.out.println();
        System.out.println("Sort list by Last Name with Java 8");
        employeeList.sort(Comparator.comparing(employee -> employee.getLastName().toLowerCase()));
        System.out.println(employeeList);

        // Convert HashSet to TreeSet
        System.out.println("===============================");
        for (Employee e : employeeSet) {
            System.out.print(e);
            System.out.println(" ==> " + e.hashCode());
        }
        System.out.println("size before : " + employeeSet.size());
        System.out.println("Sort by converting Hashset to TreeSet");
        Set<Employee> employeeTreeSet = new TreeSet<>(employeeSet);
        System.out.println(employeeTreeSet);
        System.out.println("size before : " + employeeTreeSet.size());

    }

    private static void customSetObjects() {
        Employee e1 = new Employee(1234, 75000, "pavan", "khachane");
        Employee e2 = new Employee(1234, 75000, "Pavan", "Khachane");
        Employee e3 = new Employee(2081, 50000, "Prasanna", "Phirke");
        Employee e4 = new Employee(4567, 999999, "Satyam", "Wakekar");
        Employee e5 = new Employee(1234, 75000, "Pavan", "K");
        Employee e6 = new Employee(1000, 9999999, "Sameer", "M");


        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(e1);

        employeeSet.add(e2);
        employeeSet.add(e3);
        employeeSet.add(e4);
        employeeSet.add(e5);
        employeeSet.add(e6);

        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);
        System.out.println("e1 == e2  ==> " + (e1 == e2));
        System.out.println("(e1.equals(e2)  ==> " + (e1.equals(e2)));
        System.out.println("e1.hashCode() ==> " + e1.hashCode());
        System.out.println("e2.hashCode() ==> " + e2.hashCode());

        System.out.println("Size : " + employeeSet.size() + " " + employeeSet);


    }

    private static void initializeDefaultList() {

        String[] stringArray = {"foo", "bar", "baz", "foo", "bar", "baz", "Hinjawadi", "Bhugaon", "Magarpatta",
                "Hinjawadi", "Shivaji Nagar", "Wakad", "Hadapsar", "Hinjawadi", "Balewadi High Street", "Yerawada", "Bavdhan",
                "Kalyani Nagar", "Baner", "Koregaon Park", "Pimple Saudagar"};

        List<String> areaList = new ArrayList<>(Arrays.asList(stringArray));

        // Printing List which contains duplicate objects
        System.out.println("Size of ArrayList : " + areaList.size() + " -> " + areaList);

        // Initializing Empty HashSet
        Set<String> areaSet = new HashSet<>();
        System.out.println(areaSet);

        areaSet.addAll(areaList);
        System.out.println("Size of areaSet : " + areaSet.size() + " -> " + areaSet);

        areaSet.add(null);
        areaSet.add(null);
        System.out.println("Size of areaSet : " + areaSet.size() + " -> " + areaSet);

        System.out.println(" areaSet.contains(\"Baner\") -> " + areaSet.contains("Baner"));
        System.out.println(" areaSet.hashCode() -> " + areaSet.hashCode());

        System.out.println("------------Test-------------------");

        System.out.println("Set example .....");
        Set<String> set = new HashSet<String>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("1");
        set.add("2");
        set.add("5");
        for (String temp : set){
            System.out.println(temp);
        }


    }

    private static void printInstructions() {

        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To Initialize HashSet with Default Values");
        System.out.println("\t 2 - To use Custom Objects in HashSet");
        System.out.println("\t 3 - To sort Custom Objects in HashSet");
        System.out.println("\t 4 - To compare Default and Custom Objects in HashSet");
        System.out.println("\t 5 - To performSetOperations in HashSet");
        System.out.println("\t 6 - To create TreeSet");
        System.out.println("\t 7 - To create LinkedHashSet");
        System.out.println("\t 10 - To quite an application");
    }

}
