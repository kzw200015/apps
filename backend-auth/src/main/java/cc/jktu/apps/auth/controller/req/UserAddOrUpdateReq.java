package cc.jktu.apps.auth.controller.req;

import lombok.Data;

@Data
public class UserAddOrUpdateReq {

    private String username;
    private String password;

}
