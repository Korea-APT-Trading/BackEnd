package com.ssafy.vue.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(value = "MemberDto : 회원정보", description = "회원의 상세 정보를 나타낸다.")
public class MemberDto {

    @ApiModelProperty(value = "회원 아이디")
    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(min = 5, max = 20, message = "아이디는 5자 이상 20자 이하로 입력해주세요.")
    private String userid;

    @ApiModelProperty(value = "회원 이름")
    @NotBlank(message = "이름을 입력해주세요.")
    @Size(max = 20, message = "이름을 20자 이하로 입력해주세요.")
    private String username;

    @ApiModelProperty(value = "회원 비밀번호")
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, message = "비밀번호를 8자 이상으로 입력해주세요.")
    private String userpwd;

    @ApiModelProperty(value = "회원 이메일")
	@Email(message = "이메일 형식을 입력해주세요.")
	@NotBlank(message = "이메일을 입력해주세요")
    private String email;

    @ApiModelProperty(value = "회원 가입일")
    private String joindate;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    @Override
    public String toString() {
        return "MemberDto [userid=" + userid + ", username=" + username + ", userpwd=" + userpwd + ", email=" + email
                + ", joindate=" + joindate + "]";
    }

}
