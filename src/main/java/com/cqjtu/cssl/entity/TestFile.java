package com.cqjtu.cssl.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Table(name = "tbl_test_file")
public class TestFile {

    @Id
    private int id;
    private String fileName;
    private byte[] file;

    public TestFile() {
    }

    public TestFile(String fileName, byte[] file) {
        this.fileName = fileName;
        this.file = file;
    }

    public TestFile(int id, String fileName, byte[] file) {
        this.id = id;
        this.fileName = fileName;
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
