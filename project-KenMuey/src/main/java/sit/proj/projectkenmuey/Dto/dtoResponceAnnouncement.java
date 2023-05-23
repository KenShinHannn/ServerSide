package sit.proj.projectkenmuey.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
public class dtoResponceAnnouncement {
    @Id
    @JsonProperty("id")
    private Integer announcementId;
    private String announcementTitle;
    private String announcementDescription;
    private ZonedDateTime publishDate;
    private ZonedDateTime closeDate;
    @Column(name = "announcementDisplay", nullable = false, columnDefinition = "ENUM('Y', 'N') DEFAULT 'N'")
    private String announcementDisplay;
    @JsonProperty("announcementCategory")
    private String CategoryCategoryName;
    @JsonProperty("categoryId")
    private String CategoryCategoryID;
}
