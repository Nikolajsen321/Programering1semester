package model;

public class NedarvningTest {

	public static void main(String[] args) {
		//TODO Auto-generated method stub
		System.out.println("model.Person:");

		Person person = new Person("Hanne", "Sydbakken 27", "Datalog");

		Student student = new Student("Margrethe", "Ringvej 7", "STX", 9.5, "DMU01");

		Teacher teachr = new Teacher( " Bent ", "Marsvej", "Underviser", 25000,1);

		person.udskrivPerson();

		System.out.println();

		System.out.println("model.Student:");

		student.udskrivPerson();// kalder overrided metode

		System.out.println();
		teachr.udskrivPerson();
		System.out.println();

		student.udskrivAdresse(); // kalder egen metode

		System.out.println(student.getName()); // kalder nedarvet metode

//		System.out.println(teachr.yearlySallary());

//		System.out.println(teachr.totalSallary());

		System.out.println();

			teachr.setName("KNALDE ");
			teachr.setYears( 3);
			teachr.setSallary(30000);
			teachr.udskrivPerson();



	}

}
