package demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


    public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");/**/

            ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Doctor doctor = context.getBean(Doctor.class);
        doctor.setQualification("MBBM");
        System.out.println(doctor);
        doctor.assist();
//      doctor.getNurse().assist();
//
        System.out.println("========");
        Doctor doctor1 = context.getBean(Doctor.class);
        System.out.println(doctor1);

        Nurse nurse = context.getBean("nurse", Nurse.class);
//        nurse.assist();
//
        Stuff staff = context.getBean("nurse", Nurse.class);
//        staff.assist();
//
//        Stuff staff1 =  context.getBean(Doctor.class);
//        staff1.assist();
//        System.out.println(staff1);
    }
}
