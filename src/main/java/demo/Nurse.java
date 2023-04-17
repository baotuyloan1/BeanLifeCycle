package demo;

import org.springframework.stereotype.Component;

@Component
public class Nurse implements Stuff{

    public void assist() {
        System.out.println("Nurse is assisting");
    }
}
