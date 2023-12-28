package com.pabloagustin.user;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

	@Id
	@SequenceGenerator(
			name = "user_id_sequence",
			sequenceName = "user_id_sequence"
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_id_sequence"
	)
	private Integer id;
	private String name;
	private String lastname;
	private String email;

}
