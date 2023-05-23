package sit.proj.projectkenmuey.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Table(name = "announcement")
@Getter
@Setter
@Entity
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer announcementID;
    @Column(nullable = false)
    private String announcementTitle;
    private String announcementDescription;
    private ZonedDateTime publishDate;
    private ZonedDateTime closeDate;
    @Column(name = "announcementDisplay", nullable = false, columnDefinition = "ENUM('Y', 'N') DEFAULT 'N'")
    private String announcementDisplay;
    @ManyToOne
    @JoinColumn(name = "categoryID")
//    @JsonIgnore
    private Category announcementCategory;
    private Integer viewCount;

    public Integer getViewCount() {
        return viewCount != null ? viewCount : 0;
    }

}