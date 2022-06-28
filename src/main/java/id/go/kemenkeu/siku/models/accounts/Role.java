package id.go.kemenkeu.siku.models.accounts;

import id.go.kemenkeu.siku.models.AuditModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "role")
public class Role extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "Name is required")
    private String name;

    /*
       Mirror FK
    */
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "role")
    private List<RoleFeature> roleFeature;

    public boolean isAdmin(){
        return id == 1;
    }
    public boolean isCustomer(){
        return id == 2;
    }

    public String getNamaLowerCase(){
        return this.name.toLowerCase();
    }
}

