package jpabasic.reserve.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hotel_id")
    private String hotelId;

    private int mark;

    @Column(name = "writer_name")
    private String writerName;

    private String comment;

    @Column(name = "createed")
    private LocalDateTime created;

    protected Review() {
    }

    public Review(String hotelId, int mark, String writerName, String comment) {
        this.hotelId = hotelId;
        this.mark = mark;
        this.writerName = writerName;
        this.comment = comment;
        this.created = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getHotelId() {
        return hotelId;
    }

    public int getMark() {
        return mark;
    }

    public String getWriterName() {
        return writerName;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
