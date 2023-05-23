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
public class userDtoDetail {
    @Id
    @JsonProperty("id")
    private Integer announcementId;
    private String announcementTitle;
    @JsonProperty("announcementCategory")
    private String CategoryCategoryName;
    private String announcementDescription;
    private ZonedDateTime closeDate;
    @Column(name = "announcementDisplay", nullable = false, columnDefinition = "ENUM('Y', 'N') DEFAULT 'N'")
    private String announcementDisplay;

}
