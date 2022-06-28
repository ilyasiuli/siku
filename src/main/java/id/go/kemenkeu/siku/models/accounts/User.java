package id.go.kemenkeu.siku.models.accounts;

import id.go.kemenkeu.siku.models.AuditModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class User extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;
    private String password;
    private String name;
    private String phone;
    private String nip;

    @NotBlank
    private String email;
    /*
    0: Inactive
    1: Active
    2: Banned
     */
    private Integer status;
    private String image;
    private Boolean active;

    private String resetPasswordToken;
    private String activationToken;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinColumn(name = "role_id")
    private Role role;

    public boolean isAdmin() {
        return role.isAdmin();
    }

    public void setUpdate(User user) {
        this.resetPasswordToken = user.getResetPasswordToken();
    }

    public String getEmailAt() {
        return email.replace("@", "[at]");
    }
}

