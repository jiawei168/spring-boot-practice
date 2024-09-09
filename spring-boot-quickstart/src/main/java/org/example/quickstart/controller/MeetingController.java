package org.example.quickstart.controller;

import org.example.quickstart.entity.Meeting;
import org.example.quickstart.service.MeetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meetings")
public class MeetingController {
    private final MeetingService meetingService;
    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }
    @PostMapping("/check")
    public ResponseEntity<String> checkAvailability(@RequestBody Meeting meeting) {
        //调用服务方法检查会议室是否在该时间段内可用
        if(meetingService.isRoomAvailable(meeting)){
            meetingService.addMeeting(meeting);
            return ResponseEntity.ok("会议室可用，会议已预订！");
        }else{
            //如果会议室不可用，返回冲突状态和不可用的提示信息
            return ResponseEntity.status(404).body("会议室不可用！");

        }
    }
}
