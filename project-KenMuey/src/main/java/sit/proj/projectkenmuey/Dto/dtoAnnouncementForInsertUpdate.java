package sit.proj.projectkenmuey.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import sit.proj.projectkenmuey.validate.ValidateCategory;
import sit.proj.projectkenmuey.validate.ValidateDisplay;
import sit.proj.projectkenmuey.validate.validateTime;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@Validated
@validateTime(publishDate = "publishDate",closeDate = "closeDate")
public class dtoAnnouncementForInsertUpdate {
    @Id
    @JsonProperty("id")
    private Integer announcementId;

    @NotBlank(message = "must not be blank")
    @NotNull
    @Size(min = 1, max = 200)
    private String announcementTitle;

    @JsonProperty("categoryId")
    @NotNull
    @ValidateCategory
    private Integer categoryId;

    @NotBlank(message = "must not be blank")
    @NotNull
    @Size(min = 1, max = 10000)
    private String announcementDescription;

    @Future(message = "must be a date in the present or in the future")
    private ZonedDateTime publishDate;

    @Future(message = "must be a future date")
    private ZonedDateTime closeDate;

    @ValidateDisplay(message = "must be either 'Y' or 'N'")
    private String announcementDisplay;


}