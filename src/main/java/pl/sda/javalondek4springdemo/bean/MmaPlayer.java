package pl.sda.javalondek4springdemo.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("hogan")
public class MmaPlayer implements Player {
    @Override
    public void play() {
        System.out.println("I'm mma player");
    }
}
