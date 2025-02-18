package com.libarymanagment.libarymanagement.Repository;

import com.libarymanagment.libarymanagement.Entity.IssueRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRecordRepository extends JpaRepository<IssueRecord,Long> {
}
