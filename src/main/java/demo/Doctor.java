package demo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(scopeName = "prototype")
public class Doctor implements Stuff, BeanNameAware {

    @Override
    public String toString() {
        return "Doctor{" +
                "qualification='" + qualification + '\'' +
                '}';
    }

    private String qualification;
    private Nurse nurse;

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void assist() {
        System.out.println("Doctor is assisting");
    }

    public Doctor(String qualification) {
        this.qualification = qualification;
    }

    public Doctor(String qualification, Nurse nurse) {
        this.qualification = qualification;
        this.nurse = nurse;
    }

    public Doctor() {
    }


    @Override
    public void setBeanName(String name) {
//        ĐƯợc gọi đầu tiên SPring IoC COntainer tạo ra 1 instance mới của bean và sau khi thiết lập tất cả
//        thuộc tính của bean nhưng trước bất kỳ phương thức nào khác của bean được gọi
//       Lấy tên của bean để sử dụng cho mục đích nào đó
        System.out.println("This name of Bean is: " + name);
    }

    @PostConstruct
    public void postConstruct() {
//    Được gọi sau setBeanName
//        Muốn dùng @PostCOnstructor phải dùng thư viện javax.annotation-api
// Khởi tạo các giá trị mặc định cho thuộc tính của bean.
//Thiết lập các kết nối đến các tài nguyên bên ngoài, chẳng hạn như cơ sở dữ liệu.
//Khởi tạo và thiết lập các thành phần liên quan đến bean.
//Thiết lập các thông số mặc định cho bean.
        this.setQualification("PostConstructor was edited");
        System.out.println("Post Construct Method is called");
    }
}
