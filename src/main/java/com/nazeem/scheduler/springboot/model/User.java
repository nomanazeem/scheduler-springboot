package com.nazeem.scheduler.springboot.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="users")
@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
}