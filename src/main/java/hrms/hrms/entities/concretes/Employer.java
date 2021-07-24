package hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import hrms.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@Entity
@Table(name="employers")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Employer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;


    @Column(name="web_site")
    private String website;

    @Column(name="company_name")
    private String companyName;

    @Column(name="telefon")
    private String telNumber;

    @Column(name = "verified",columnDefinition = "boolean default false")
    private boolean verified;


    public Employer(int id, String email, String password,  String website, String companyName,
                    String telNumber,boolean verified) {
        super(id, email, password);
        this.id=id;
        this.website = website;
        this.companyName = companyName;
        this.telNumber = telNumber;
        this.verified = verified;
    }
}
