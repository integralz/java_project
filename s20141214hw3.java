package hw3;



class Employee{
	private long id;
	private String name;
	private int age;
	
	public Employee(long id1, String name1, int age1) {
		id = id1;
		name = name1;
		age = age1;
	}
	
	public void employeelist() {
		System.out.format("%03d", id);
		System.out.print(", " + name + ", " + age);
	}
	
}
class Manager extends Employee{
	private String department;
	
	public Manager(long id1, String name1, int age1, String department1){
		super(id1, name1, age1);
		department = department1;
	}
	
	public void managerlist() {
		System.out.println(", " + department + "]");
	}
}
public class s20141214hw3 {
	public static void main(String[] args) {
		Employee[] list = new Employee[7];
		list[0] = new Employee(1, "John", 27);
		list[1] = new Employee(2, "Eujin", 25);
		list[2] = new Employee(3, "Alex", 26);
		list[3] = new Employee(4, "Jenny", 23);
		list[4] = new Employee(5, "Tom", 25);
		list[5] = new Manager(1, "Andy", 33, "Marketing");
		list[6] = new Manager(2, "Kate", 30, "sales");
		
		System.out.println("===Employee===");
		for(int i = 0; i < 5; i++) {
			System.out.print("[e");
			list[i].employeelist();
			System.out.println("]");
		}
		System.out.println("===Manager===");
		for(int i = 5; i < 7; i++) {
			System.out.print("[m");
			list[i].employeelist();
			((Manager)list[i]).managerlist();
		}

	}

}
