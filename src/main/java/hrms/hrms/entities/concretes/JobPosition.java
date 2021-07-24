package hrms.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="positions")
public class JobPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  int id;

    @Column(name="name")
    private  String name;
    public JobPosition(){};
    public JobPosition(int id,String name) {
        this.id = id;
        this.name = name;
    }
}
