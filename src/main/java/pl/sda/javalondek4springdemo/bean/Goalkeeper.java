package pl.sda.javalondek4springdemo.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

<<<<<<< HEAD
@Primary
@Component("buffon")
public class Goalkeeper implements Player {
=======
@Component("buffon")
@Primary
public class Goalkeeper implements Player {

>>>>>>> feature/relations-wb
    @Override
    public void play() {
        System.out.println("I'm goalkeeper");
    }
}
