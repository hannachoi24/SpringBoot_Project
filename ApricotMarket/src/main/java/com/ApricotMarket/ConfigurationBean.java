package com.ApricotMarket;

import com.ApricotMarket.repository.ItemMemoryRepository;
import com.ApricotMarket.repository.ItemRepository;
import com.ApricotMarket.repository.UserRepository;
import com.ApricotMarket.service.ItemService;
import com.ApricotMarket.service.ItemServiceImpl;
import com.ApricotMarket.service.UserService;
import com.ApricotMarket.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class ConfigurationBean {
    private final DataSource datasource;
    private EntityManager em;
    private final UserRepository userRepository;
    public ConfigurationBean(DataSource datasource, EntityManager em, UserRepository userRepository) {
        this.datasource = datasource;
        this.em = em;
        this.userRepository = userRepository;

    }

    @Bean
    public UserService userService(){ return new UserServiceImpl(userRepository);
    }
    @Bean
    public ItemRepository itemRepository() { return new ItemMemoryRepository(em);
    }
    @Bean
    public ItemService itemService(){ return new ItemServiceImpl(itemRepository());
    }

}
