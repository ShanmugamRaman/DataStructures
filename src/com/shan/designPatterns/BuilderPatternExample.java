package com.shan.designPatterns;

public class BuilderPatternExample {
	public static void main(String[] args) {
		Employee employee = Employee.builder().setEmpId(1).setEmpName("Shan").build();
	}
}

class Employee {
	private int empId;
	private String empName;

	static EmployeeBuilder builder() {
		return new EmployeeBuilder();
	}

	public Employee(EmployeeBuilder builder) {
		this.empId = builder.empId;
		this.empName = builder.empName;
	}
	
	@Override
	public String toString() {
		return this.empId + "--"+ this.empName;
	}
	
	

	static class EmployeeBuilder {
		private int empId;
		private String empName;

		public EmployeeBuilder setEmpId(int empId) {
			this.empId = empId;
			return this;
		}

		public EmployeeBuilder setEmpName(String empName) {
			this.empName = empName;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}

	}

}
