package com.voyager.mt.octo.config.error.exception;

public class IssueNotFoundException  extends RuntimeException {
    public IssueNotFoundException(Long issueID) {
        super("Issue with id " + issueID + " not found!");
    }
}
