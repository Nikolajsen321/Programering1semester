public class Customer implements Comparable<Customer> {
	private String lastName;
	private String firstName;
	private int age;
	
	public Customer(String lastName, String firstName, int age) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
	}


	public int getAge() {
		return age;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}



	
	@Override
    public String toString(){
		return lastName + " " + firstName + " " + age;
	}

	@Override
	public int compareTo(Customer o) {
		return this.firstName.compareTo(o.firstName);


	}
}
