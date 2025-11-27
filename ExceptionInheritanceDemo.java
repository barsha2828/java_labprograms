// // Custom Exception
// class WrongAge extends Exception {
//     public WrongAge(String message) {
//         super(message);
//     }
// }

// // Base Class Father
// class Father {
//     protected int fatherAge;

//     public Father(int age) throws WrongAge {
//         if (age < 0) {
//             throw new WrongAge("Father's age cannot be negative!");
//         }
//         this.fatherAge = age;
//     }
// }

// // Derived Class Son
// class Son extends Father {
//     private int sonAge;

//     public Son(int fatherAge, int sonAge) throws WrongAge {
//         super(fatherAge); // call Father constructor
//         if (sonAge >= fatherAge) {
//             throw new WrongAge("Son's age cannot be greater than or equal to Father's age!");
//         }
//         if (sonAge < 0) {
//             throw new WrongAge("Son's age cannot be negative!");
//         }
//         this.sonAge = sonAge;
//     }

//     public void displayAges() {
//         System.out.println("Father's Age: " + fatherAge);
//         System.out.println("Son's Age: " + sonAge);
//     }
// }

// // Main Class
// public class ExceptionInheritanceDemo {
//     public static void main(String[] args) {
//         try {
//             // Valid case
//             Son s1 = new Son(45, 20);
//             s1.displayAges();

//             // Invalid case: father's age negative
//             Son s2 = new Son(-40, 15);

//         } catch (WrongAge e) {
//             System.out.println("Exception caught: " + e.getMessage());
//         }

//         try {
//             // Invalid case: son's age >= father's age
//             Son s3 = new Son(40, 45);
//         } catch (WrongAge e) {
//             System.out.println("Exception caught: " + e.getMessage());
//         }
//     }
// }

// Custom Exception
class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}

// Base Class Father
class Father {
    int fatherAge;   // no protected/private

    public Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative!");
        }
        fatherAge = age;
    }
}

// Derived Class Son
class Son extends Father {
    int sonAge;   // no protected/private

    public Son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge); // call Father constructor
        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to Father's age!");
        }
        if (sonAge < 0) {
            throw new WrongAge("Son's age cannot be negative!");
        }
        this.sonAge = sonAge;
    }

    public void displayAges() {
        System.out.println("Father's Age: " + fatherAge);
        System.out.println("Son's Age: " + sonAge);
    }
}

// Main Class

public class ExceptionInheritanceDemo {
    public static void main(String[] args) {
        try {
            System.out.println("Case 1: Valid ages");
            Son s1 = new Son(50, 20);  // valid
            s1.displayAges();
        } catch (WrongAge e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            System.out.println("Case 2: Invalid father age");
            Son s2 = new Son(-40, 15); // invalid father age
            s2.displayAges();
        } catch (WrongAge e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

