package sit.proj.projectkenmuey.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import org.springframework.web.bind.annotation.*;
import sit.proj.projectkenmuey.Dto.*;
import sit.proj.projectkenmuey.Errorexception.CustomException;
import sit.proj.projectkenmuey.ListMapper;
import sit.proj.projectkenmuey.PageDTO;
import sit.proj.projectkenmuey.entities.Announcement;
import sit.proj.projectkenmuey.services.AnnouncementService;
import sit.proj.projectkenmuey.services.CategoryService;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173", "http://intproj22.sit.kmutt.ac.th/kk3"})
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private ListMapper listMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/announcements")
    public List<dtoAnnouncementAll> getAllInfo(@RequestParam(defaultValue = "admin") String mode,
                                               @RequestParam(required = false) Integer categoryID
    ) {
        Page<Announcement> announcementPage = announcementService.getInfo(mode, 0, Integer.MAX_VALUE, categoryID);
        List<Announcement> announcementList = announcementPage.getContent();
        return listMapper.mapList(announcementList, dtoAnnouncementAll.class, modelMapper);
    }

    //     get mode pages
    @GetMapping("/announcements/pages")
    public PageDTO<dtoAnnouncementAll> getAllInfoMode(@RequestParam(defaultValue = "admin") String mode,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "5") int size,
                                                      @RequestParam(required = false) Integer category
    ) {
        Page<Announcement> announcementPage = announcementService.getInfo(mode, page, size, category);
        return listMapper.toPageDTO(announcementPage, dtoAnnouncementAll.class, modelMapper);
    }

    // get by id
    @GetMapping("/announcements/{id}")
    public dtoAnnouncementDetail getInfo(@PathVariable int id,
                                         @RequestParam(defaultValue = "active") String mode,
                                         @RequestParam(defaultValue = "false") Boolean count
    ) {
        return modelMapper.map(announcementService.getInfoById(id,mode,count), dtoAnnouncementDetail.class);
    }

    // insert
    @PostMapping("/announcements")
    public dtoResponceAnnouncement addInfoById(@Valid @RequestBody dtoAnnouncementForInsertUpdate newAnnouncement) {
        try{
            Announcement announcement = modelMapper.map(newAnnouncement, Announcement.class);
            if (newAnnouncement.getAnnouncementDisplay() == null) {
                announcement.setAnnouncementDisplay("N");
            }else{
                announcement.setAnnouncementDisplay(newAnnouncement.getAnnouncementDisplay());
            }
            announcement.setAnnouncementCategory(categoryService.sendName(newAnnouncement.getCategoryId()));
            announcementService.addInfos(announcement);
            return modelMapper.map(announcement, dtoResponceAnnouncement.class);

        }catch (Exception error){
            throw new CustomException("Can't insert");
        }
    }

    // update
    @PutMapping("/announcements/{id}")
    public dtoResponceAnnouncement updateAnnouncement( @PathVariable Integer id,@Valid @RequestBody dtoAnnouncementForInsertUpdate updateAnnouncement) {
        try {
            if (updateAnnouncement.getAnnouncementDisplay() == null) {
                updateAnnouncement.setAnnouncementDisplay("N");
            }
            Announcement announcement = modelMapper.map(updateAnnouncement, Announcement.class);
            announcement.setAnnouncementCategory(categoryService.sendName(updateAnnouncement.getCategoryId()));
            announcementService.updateInfos(id, announcement);
            return modelMapper.map(announcement, dtoResponceAnnouncement.class);
        }catch (Exception error){
            throw new CustomException("Can't edit");

        }
    }

    // delete
    @DeleteMapping("/announcements/{id}")
    public void delete(@PathVariable int id) {
        announcementService.deleteInfos(id);
    }

}
