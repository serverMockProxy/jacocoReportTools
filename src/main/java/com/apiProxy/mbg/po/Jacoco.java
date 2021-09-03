package com.apiProxy.mbg.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
@Data
public class Jacoco {

    public static final int BRANCH = 1;

    public static final int COMMIT = 2;

    public static final int ALL = 3;

    private Integer id;

    private Integer projectId;

    private Integer gitlabId;

    private String gitclonePath;

    private String jacocoProjectName;

    private Integer compareType;

    private String currentBranch;

    private String compareBranch;

    private String currentCommit;

    private String compareCommit;

    private List<Jacoco> childrens;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private String reportPath;

    private Integer taskStatus;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getGitlabId() {
        return gitlabId;
    }

    public void setGitlabId(Integer gitlabId) {
        this.gitlabId = gitlabId;
    }

    public String getGitclonePath() {
        return gitclonePath;
    }

    public void setGitclonePath(String gitclonePath) {
        this.gitclonePath = gitclonePath == null ? null : gitclonePath.trim();
    }

    public String getJacocoProjectName() {
        return jacocoProjectName;
    }

    public void setJacocoProjectName(String jacocoProjectName) {
        this.jacocoProjectName = jacocoProjectName == null ? null : jacocoProjectName.trim();
    }

    public Integer getCompareType() {
        return compareType;
    }

    public void setCompareType(Integer compareType) {
        this.compareType = compareType;
    }

    public String getCurrentBranch() {
        return currentBranch;
    }

    public void setCurrentBranch(String currentBranch) {
        this.currentBranch = currentBranch == null ? null : currentBranch.trim();
    }

    public String getCompareBranch() {
        return compareBranch;
    }

    public void setCompareBranch(String compareBranch) {
        this.compareBranch = compareBranch == null ? null : compareBranch.trim();
    }

    public String getCurrentCommit() {
        return currentCommit;
    }

    public void setCurrentCommit(String currentCommit) {
        this.currentCommit = currentCommit == null ? null : currentCommit.trim();
    }

    public String getCompareCommit() {
        return compareCommit;
    }

    public void setCompareCommit(String compareCommit) {
        this.compareCommit = compareCommit == null ? null : compareCommit.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath == null ? null : reportPath.trim();
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}