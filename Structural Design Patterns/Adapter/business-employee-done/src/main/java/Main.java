
public class Main {

	public static void main(String[] args) {

		BusinessCardDesigner designer = new BusinessCardDesigner();

		/** Using Class/Two-way adapter **/
		EmployeeClassAdapter employeeClassAdapter = new EmployeeClassAdapter();
		populateEmployeeData(employeeClassAdapter);
		String card1 = designer.designCard(employeeClassAdapter);
		System.out.println(card1);

		System.out.println("************************");

		/** Using Object Adapter **/
		Employee employee = new Employee();
		populateEmployeeData(employee);
		EmployeeObjectAdapter employeeObjectAdapter = new EmployeeObjectAdapter(employee);
		String card2 = designer.designCard(employeeObjectAdapter);
		System.out.println(card2);
	}

	private static void populateEmployeeData(Employee employee) {
		employee.setFullName("Elliot Alderson");
		employee.setJobTitle("Security Engineer");
		employee.setOfficeLocation("Allsafe Cybersecurity, New York City, New York");
	}
}
