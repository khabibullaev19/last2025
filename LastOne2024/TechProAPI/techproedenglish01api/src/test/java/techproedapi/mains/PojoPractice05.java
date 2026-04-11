package techproedapi.mains;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoPractice05 {

    @SerializedName("employee_name")
    @Expose
    private String employeeName;

    public PojoPractice05() {
    }

    public PojoPractice05(String employeeName, String employeeSalary, String employeeAge, String profileImage) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeAge = employeeAge;
        this.profileImage = profileImage;
    }

    @SerializedName("employee_salary")
    @Expose
    private String employeeSalary;
    @SerializedName("employee_age")
    @Expose
    private String employeeAge;

    public String getStatus() {
        return status;
    }

    public PojoPractice05(String status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public String toString() {
        return "PojoPractice05{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeSalary='" + employeeSalary + '\'' +
                ", employeeAge='" + employeeAge + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("profile_image")
    @Expose
    private String profileImage;
    private String status;
    private String message;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

}
