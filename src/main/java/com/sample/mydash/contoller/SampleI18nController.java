package com.sample.mydash.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleI18nController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("welcome")
    public String welcome() {    //@RequestHeader(name = "Accept-Language", required = false)Locale locale

        return messageSource.getMessage("welcome.message", null,
                "Default Message", LocaleContextHolder.getLocale());
    }
}
