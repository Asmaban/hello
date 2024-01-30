package cons;
public class Student {
	String name;
	int rollNo;
	String phoneNo;
	String address;
	
	public Student() {
		name = " ";
		rollNo = 0;
		phoneNo = " ";
		address = " ";
	}
	public void displayInformation() {
		System.out.println("Name: " + name);
		System.out.println("RollNo: " + rollNo);
		System.out.println("PhoneNo: " + phoneNo);
		System.out.println("Address: " + address);
	}
	public Student(String name, int rollNo, String phoneNo, String address) {
		this.name = name;
		this.rollNo = rollNo;
		this.phoneNo = phoneNo;
		this.address = address;
	}
	public static void main(String args[]) {
		Student sam = new Student();
		Student john = new Student();
		sam = new Student("sam", 101, "1234567890", "Ram Nagar");
		john = new Student ("john", 102, "2233445566", "Kovur nagar");
		System.out.println("Student 1: ");
		sam.displayInformation();
		System.out.println("\nStudent 2: ");
		john.displayInformation();
	}
}
