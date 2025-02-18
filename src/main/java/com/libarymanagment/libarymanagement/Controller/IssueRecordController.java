package com.libarymanagment.libarymanagement.Controller;

import com.libarymanagment.libarymanagement.Entity.IssueRecord;
import com.libarymanagment.libarymanagement.Service.IssueRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issuerecords")
public class IssueRecordController {

    @Autowired
    private IssueRecordService issueRecordService;

    @PostMapping("/issuethebook/{bookid}")
    public ResponseEntity<IssueRecord> issueTheBook(@PathVariable Long bookid) {
        return ResponseEntity.ok(issueRecordService.issueTheBook(bookid));
    }

    @PostMapping("/returnthebook/{bookid}")
    public ResponseEntity<IssueRecord> returnTheBook(@PathVariable Long bookid) {
        return ResponseEntity.ok(issueRecordService.returnTheBook(bookid));
    }

}
