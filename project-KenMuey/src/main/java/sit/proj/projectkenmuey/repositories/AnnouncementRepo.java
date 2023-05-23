package sit.proj.projectkenmuey.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sit.proj.projectkenmuey.entities.Announcement;
import org.springframework.data.domain.Pageable;
import sit.proj.projectkenmuey.entities.Category;

import java.util.List;


public interface AnnouncementRepo extends JpaRepository<Announcement,Integer> {
    @Query(value = "SELECT * FROM announcement WHERE announcementDisplay = 'Y' AND ((publishDate IS NULL AND closeDate IS NULL) OR (publishDate IS NOT NULL AND closeDate IS NULL AND (publishDate = now() OR publishDate < now())) OR (publishDate IS NOT NULL AND closeDate IS NOT NULL AND (publishDate = now() OR (publishDate < now() AND closeDate > now()))) OR (publishDate IS NULL AND closeDate IS NOT NULL AND closeDate > now())) ", nativeQuery = true)
    Page<Announcement> getAnnouncementDisplayIsYAndActive(Pageable pageable);

    @Query(value = "SELECT * FROM announcement WHERE categoryID = :categoryId and announcementDisplay = 'Y' and ((publishDate IS NULL AND closeDate IS NULL) OR (publishDate IS NOT NULL AND closeDate IS NULL AND (publishDate = now() OR publishDate < now())) OR (publishDate IS NOT NULL AND closeDate IS NOT NULL AND (publishDate = now() OR (publishDate < now() AND closeDate > now()))) OR (publishDate IS NULL AND closeDate IS NOT NULL AND closeDate > now()))", nativeQuery = true)
    Page<Announcement> getCategoryAndActive(Integer categoryId,Pageable pageable);

    @Query(value = "select * from announcement where announcementDisplay = 'Y' and closeDate is not null  and closeDate <= now() ",nativeQuery = true)
    Page<Announcement> getAnnouncementByDisplayIsYAndClose(Pageable pageable);

    @Query(value = "select * from announcement where categoryID = :categoryId and announcementDisplay = 'Y' and closeDate is not null  and closeDate <= now() ",nativeQuery = true)
    Page<Announcement> getCategoryAndClose(Integer categoryId,Pageable pageable);

    @Query(value = "select * from announcement where ", nativeQuery = true)
    List<Announcement> getAnnouncement();
}
