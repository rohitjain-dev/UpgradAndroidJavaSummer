
class Employee {
    int salary;
}

class HRDeparment extends Employee{
    int bonus;
}

class Intern extends HRDeparment{
    
    public static void main(String[] args) {
        Intern i = new Intern();
        i.salary = 5000;
        i.bonus = 0;
        int total = i.salary+i.bonus;
        System.out.println("The Toatal amount to be paid to an Intern is :" + total );
    }
}
