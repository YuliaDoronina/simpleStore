package org.store.webapp.web.ui.roleadmin;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping(value = "/admin/index")
public class IndexAdmin {

    @GetMapping
    public String index() {
        return "admin/indexAdmin";
    }
}
