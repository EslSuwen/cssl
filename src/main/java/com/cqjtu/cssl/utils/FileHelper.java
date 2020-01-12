package com.cqjtu.cssl.utils;

public class FileHelper {

    private String fileName;
    private String fileBinary;
    private String fileBase64;

    public FileHelper() {
    }

    public FileHelper(String fileName, String fileBinary, String fileBase64) {
        this.fileName = fileName;
        this.fileBinary = fileBinary;
        this.fileBase64 = fileBase64;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileBinary() {
        return fileBinary;
    }

    public void setFileBinary(String fileBinary) {
        this.fileBinary = fileBinary;
    }

    public String getFileBase64() {
        return fileBase64;
    }

    public void setFileBase64(String fileBase64) {
        this.fileBase64 = fileBase64;
    }
}
