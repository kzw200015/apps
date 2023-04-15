package cc.jktu.apps.auth.controller.req;

import lombok.Data;

@Data
public class LoginReq {

    private String username;
    private String password;

}