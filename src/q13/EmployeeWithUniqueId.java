package q13;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 13:39
 */
public class EmployeeWithUniqueId extends Employee {
    public EmployeeWithUniqueId(long id, String name, String phone_num, String job_title) {
        super(id, name, phone_num, job_title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        EmployeeWithUniqueId that = (EmployeeWithUniqueId) o;

        return this.getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return (int) getId();
    }
}
