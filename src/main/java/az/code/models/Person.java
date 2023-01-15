package az.code.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "my_people")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_post"
    )
    @SequenceGenerator(
            name = "seq_post",
            allocationSize = 5
    )

    private Long id;
    private String name;
    @Column(name = "last_name")
    private String surname;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private List<Address> addresses;


}
