package pl.sda.javalondek4springdemo.model.onetoone.bidirectional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sda.javalondek4springdemo.repository.onetoone.bidirectional.CatRepository;
import pl.sda.javalondek4springdemo.repository.onetoone.bidirectional.OwnerRepository;

@Profile("onetoone-bidirectional")
@Component
public class OneToOneBidirectionalExample implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(OneToOneBidirectionalExample.class);

    private final OwnerRepository ownerRepository;

    private final CatRepository catRepository;

    public OneToOneBidirectionalExample(OwnerRepository ownerRepository, CatRepository catRepository) {
        this.ownerRepository = ownerRepository;
        this.catRepository = catRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        Owner owner = new Owner();
//        owner.setFirstName("maniek");
//        owner.setLastName("p.");
//
//        Cat mruczek = new Cat();
//        mruczek.setName("mruczek");
//
//        catRepository.save(mruczek);
//        logger.info("mruczek id after save: [{}]", mruczek.getId());
//
//        owner.setCat(mruczek);
////        ownerRepository.save(owner);
//
//        mruczek.setOwner(owner);

        // save to db
        Owner olaf = new Owner();
        olaf.setFirstName("olaf");
        olaf.setLastName("olaf");

        Cat lobuz = new Cat();
        lobuz.setName("lobuz");
        lobuz.setOwner(olaf);
        olaf.setCat(lobuz);
        ownerRepository.save(olaf);
    }
}
