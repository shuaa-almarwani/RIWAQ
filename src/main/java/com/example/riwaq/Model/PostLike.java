package com.example.riwaq.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer postId;

//     @ManyToOne
//     @JoinColumn(name = "user_id", insertable = false, updatable = false)
//     private User user;
//
//     @ManyToOne
//     @JoinColumn(name = "post_id", insertable = false, updatable = false)
//     private Post post;
}
