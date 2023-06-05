package model;

public class AuthUserDTO extends StorableEntity<Long> {
    public String getFullname() {
        return fullname;
    }

    public AuthUserDTO(String fullname, UserType userType) {
        this.fullname = fullname;
        this.userType = userType;
    }

    public AuthUserDTO(Long aLong, String fullname, UserType userType) {
        super(aLong);
        this.fullname = fullname;
        this.userType = userType;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    private String fullname;
    private UserType userType;
}
