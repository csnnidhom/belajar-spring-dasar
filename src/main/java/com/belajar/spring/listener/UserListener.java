package com.belajar.spring.listener;

import com.belajar.spring.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserListener {

    @EventListener(classes = LoginSuccessEvent.class)
    public void onLoginListener(LoginSuccessEvent event){
        log.info("Success login for user with annotation event listener {}", event.getUser());
    }

    @EventListener(classes = LoginSuccessEvent.class)
    public void onLoginListener2(LoginSuccessEvent event){
        log.info("Success login for user with annotation event listener {}", event.getUser());
    }

    @EventListener(classes = LoginSuccessEvent.class)
    public void onLoginListener3(LoginSuccessEvent event){
        log.info("Success login for user with annotation event listener {}", event.getUser());
    }
}
