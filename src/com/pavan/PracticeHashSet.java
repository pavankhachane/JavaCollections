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
                case 10:
                    quit = true;
                    break;
                default:
                    System.out.println("Illegal Input");
                    break;
            }
        }

    }

    private static void performSetOperations() {
        Integer[] A = {22, 45, 33, 66, 55, 34, 77};
        Integer[] B = {33, 2, 83, 45, 3, 12, 55};

        Set<Integer> set1 = new HashSet<>(Arrays.asList(A));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(B));

        System.out.println("Size = " + set1.size() + " " + set1);
        System.out.println("Size = " + set2.size() + " " + set2);

        // Finding Union of set1 and set2
        System.out.println("Union of set1 and set2 : Combine all elements from set 1 and set 2 and avoid duplicates");

        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        System.out.println("Size of Union Set : " + unionSet.size() + " " + unionSet);

        // Finding Intersection of set1 and set2
        System.out.println("Intersection of set1 and set2 : Find Common elements from set 1 and set 2 and avoid duplicates");

        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        System.out.println("Size of Union Set : " + intersectionSet.size() + " " + intersectionSet);

        // Finding Difference of set1 and set2
        Set<Integer> difference_data = new HashSet<Integer>(set1);
        difference_data.removeAll(set2);
        System.out.print("Difference of set1 and set2 is:");
        System.out.println(difference_data);
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

    }

    private static void printInstructions() {

        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To Initialize HashSet with Default Values");
        System.out.println("\t 2 - To use Custom Objects in HashSet");
        System.out.println("\t 3 - To sort Custom Objects in HashSet");
        System.out.println("\t 4 - To compare Default and Custom Objects in HashSet");
        System.out.println("\t 10 - To quite an application");
    }

}
