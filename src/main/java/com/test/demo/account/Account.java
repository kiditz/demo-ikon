package com.test.demo.account;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Account {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "account")
	private String name;
}
