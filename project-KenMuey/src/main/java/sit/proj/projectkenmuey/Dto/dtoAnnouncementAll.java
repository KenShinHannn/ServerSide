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
public class dtoAnnouncementAll {
    @Id
    @JsonProperty("id")
    private Integer announcementID;
    private String announcementTitle;
    @JsonProperty("announcementCategory")
    private String categoryCategoryName;
    private ZonedDateTime publishDate;
    private ZonedDateTime closeDate;
    @Column(name = "announcementDisplay", nullable = false, columnDefinition = "ENUM('Y', 'N') DEFAULT 'N'")
    private String announcementDisplay;
    private Integer viewCount = 0;
}