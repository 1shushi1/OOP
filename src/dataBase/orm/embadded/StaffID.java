package dataBase.orm.embadded;

public class StaffID {
    private long id;
    private String department;
    public StaffID(long id, String department){
        this.id = id;
        this.department = department;
    }
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!(o instanceof StaffID)){
            return false;
        }
        StaffID staffID = (StaffID) o;
        return id == staffID.id && department.equals(staffID.department);
    }
    @Override
    public int hashCode(){
        int hashCode = 13;
        hashCode = hashCode * 13 + Long.hashCode(id);
        return hashCode * 13 + department.hashCode();
    }
    public long getId(){
        return id;
    }
    public String getDepartment(){
        return department;
    }
}
