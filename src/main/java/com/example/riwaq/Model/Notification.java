package com.example.riwaq.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String message;

    @NotEmpty
    @Pattern(regexp = "FRIEND_REQUEST|FRIEND_ACCEPTED|POST_LIKE|NEW_REVIEW|GENERAL", message = "Type must be FRIEND_REQUEST, FRIEND_ACCEPTED, POST_LIKE, NEW_REVIEW, or GENERAL")
    @Column(nullable = false)
    private String type;

    private Boolean sendByEmail;
    private Boolean sendByWhatsApp;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

     @ManyToOne
     @JoinColumn(name = "recipient_id", insertable = false, updatable = false)
     private User recipient;

     @ManyToOne
     @JoinColumn(name = "sender_id", insertable = false, updatable = false)
     private User sender;
}