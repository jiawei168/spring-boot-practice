package org.example.quickstart.service;

import org.example.quickstart.entity.Meeting;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingService {
    private final List<Meeting> meetings = new ArrayList<Meeting>();
    /**
     * 检查会议室是否可用于新的会议（newMeeting）
     * @paaram newMeeting要检查的新会议对象
     * @return如果会议室在新会议的时间段内可用，则返回true；否则返回false
     */
    public boolean isRoomAvailable(Meeting newMeeting) {
        //使用Java Stream API来检查会议列表中是否有与新会议重叠的会议
        return meetings.stream().noneMatch(existingMeeting -> existingMeeting.isOverlapping(newMeeting));
        //如果存在任何与新会议时间重叠的现有会议，返回false
    }
    public void addMeeting(Meeting meeting){
        meetings.add(meeting);
    }
}
