package com.isa.user.dto;

import javax.validation.constraints.NotNull;

public class PasswordChangerDto {

    @NotNull(message = "Old password can not be null")
    private String oldPassword;
    @NotNull(message = "New password can not be null")
    private String newPassword;

    public PasswordChangerDto() {
    }

    public PasswordChangerDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }
}
