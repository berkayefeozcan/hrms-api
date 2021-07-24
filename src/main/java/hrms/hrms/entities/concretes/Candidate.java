package hrms.hrms.entities.concretes;

import hrms.hrms.entities.abstracts.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@Entity
@Table(name="candidates")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Candidate extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_of_date")
    private Date birthOfDate;

    @Column(name = "identity_number")
    private String indentityNumber;

    public Candidate(int id, String email, String password,  String firstname, String surname,
                    Date birthOfDate,String indentityNumber) {
        super(id, email, password);
        this.id=id;
        this.firstname = firstname;
        this.surname = surname;
        this.birthOfDate = birthOfDate;
        this.indentityNumber= indentityNumber;
    }

}
