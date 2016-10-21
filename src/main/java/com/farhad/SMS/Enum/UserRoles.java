package com.farhad.SMS.Enum;

/**
 * Created by FARHAD ZAMAN on 11-Jul-16.
 */
public enum UserRoles {
    ROLE_ADMIN(1),ROLE_USER(2);

    private int value;

    UserRoles(int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
