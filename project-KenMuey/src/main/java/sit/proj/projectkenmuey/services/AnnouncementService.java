package sit.proj.projectkenmuey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.proj.projectkenmuey.Errorexception.CustomException;
import sit.proj.projectkenmuey.entities.Announcement;
import sit.proj.projectkenmuey.repositories.AnnouncementRepo;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepo announcementRepo;


    // mode
    public Page<Announcement> getInfo(String mode, int page, int size, Integer categoryID) {
        Sort sort = Sort.by(Sort.Direction.DESC, "announcementID");
        Pageable pageable = PageRequest.of(page, size, sort);

        if (mode.equals("admin")) {
            return announcementRepo.findAll(pageable);
        }
        if (mode.equals("active")) {
            if (categoryID == null) {
                return announcementRepo.getAnnouncementDisplayIsYAndActive(pageable);
            }
            return announcementRepo.getCategoryAndActive(categoryID, pageable);
        }
        if (mode.equals("close")) {
            if (categoryID == null) {
                return announcementRepo.getAnnouncementByDisplayIsYAndClose(pageable);
            }
            return announcementRepo.getCategoryAndClose(categoryID, pageable);
        }
        return null;
    }


    //     get by id admin
    public Announcement getInfoById(Integer announcementID, String mode, boolean count) {
        Announcement announcement = announcementRepo.findById(announcementID).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, announcementID + "Announcement id does not exist"));

        if (mode.equals("admin")) {
            return announcement;
        } else if (mode.equals("active")) {
            if (count) {
                if (count == false) {
                    announcement.setViewCount(announcement.getViewCount() );
                    announcementRepo.saveAndFlush(announcement);
                }
                announcement.setViewCount(announcement.getViewCount() + 1);
                announcementRepo.saveAndFlush(announcement);
            }
        } else if (mode.equals("close")) {
            if (count) {
                if (count == false) {
                    announcement.setViewCount(announcement.getViewCount() );
                    announcementRepo.saveAndFlush(announcement);
                }
                announcement.setViewCount(announcement.getViewCount()  + 1);
                announcementRepo.saveAndFlush(announcement);
            }
        }
        return announcement;

    }


    //delete
    public void deleteInfos(Integer announcementID) {
        if (announcementID == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Announcement ID cannot be null");
        }
        if (announcementRepo.existsById(announcementID)) {
            announcementRepo.deleteById(announcementID);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Announcement not found");
        }
    }

    //insert
    public Announcement addInfos(Announcement newAnnouncement) {
        try {
            return announcementRepo.saveAndFlush(newAnnouncement);
        } catch (Exception error) {
            throw new CustomException("can't insert");
        }
    }

    //    update
    public Announcement updateInfos(Integer announcementID, Announcement newAnnouncement) {
        Announcement Announcement = announcementRepo.findById(announcementID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, announcementID + "does not exist!"));
        try {
            Announcement.setAnnouncementTitle(newAnnouncement.getAnnouncementTitle());
            Announcement.setAnnouncementDescription(newAnnouncement.getAnnouncementDescription());
            Announcement.setPublishDate(newAnnouncement.getPublishDate());
            Announcement.setCloseDate(newAnnouncement.getCloseDate());
            Announcement.setAnnouncementDisplay(newAnnouncement.getAnnouncementDisplay());
            Announcement.setAnnouncementCategory(newAnnouncement.getAnnouncementCategory());

            return announcementRepo.saveAndFlush(Announcement);
        } catch (Exception error) {
            throw new CustomException("can't edit");
        }
    }
}
