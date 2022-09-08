package JavaCore.FileSamples;

public class Employee {
    private int empId;
    private String firstName;
    private String lastName;

    public Employee(int empId, String firstName, String lastName) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + empId;
        result = prime * result + ((firstName == null )? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null )? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return  false;
        if(getClass() != obj.getClass()) return  false;
        Employee other = (Employee) obj;
        if(empId != other.empId) return false;
        if(lastName == null) return other.lastName == null;
        else return firstName.equals(other.firstName);
    }
}
