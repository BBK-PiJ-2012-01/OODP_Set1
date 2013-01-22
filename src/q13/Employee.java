package q13;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 12:37
 */
public class Employee {
    private final long id;
    private final String name;
    private final String phone_num;
    private final String job_title;
    private int hash = -1;

    public Employee(long id, String name, String phone_num, String job_title) {
        this.id = id;
        this.name = name;
        this.phone_num = phone_num;
        this.job_title = job_title;

        if (name == null || phone_num == null || job_title == null) {
            throw new NullPointerException();
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phone_num;
    }

    public String getJobTitle() {
        return job_title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee that = (Employee) o;

        if (this.getId() != that.id) return false;
        if (!this.getJobTitle().equals(that.getJobTitle())) return false;
        if (!this.getName().equals(that.getName())) return false;
        if (!this.getPhoneNumber().equals(that.getPhoneNumber())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        if (hash == -1) {
            hash = (int) (id ^ (id >>> 32));
            hash = 31 * hash + name.hashCode();
            hash = 31 * hash + phone_num.hashCode();
            hash = 31 * hash + job_title.hashCode();
        }

        return hash;
    }

    @Override
    public String toString() {
        return String.format("%d: %s (%s) phone: %s", id, name, job_title, phone_num);
    }
}
