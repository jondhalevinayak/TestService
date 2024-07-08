package com.testSevice.controller;

import com.testSevice.model.File;
import com.testSevice.repository.FileRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FileController {

    private final FileRepository fileRepository;

    private final HttpServletResponse response;

    public FileController(FileRepository fileRepository, HttpServletResponse response) {
        this.fileRepository = fileRepository;
        this.response = response;
    }

    @PostMapping("/upload")
    public String saveFile(@RequestBody MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            String contentType = file.getContentType();
            byte[] data = file.getBytes();
            File saveFile = File.builder().name(fileName).type(contentType).data(data).build();
            fileRepository.save(saveFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "File Saved Successfully!!";
    }

    @GetMapping("/getAllFiles")
    ArrayList<File> getAllFiles() {
        return fileRepository.findAll();
    }

    @GetMapping("/download/{fileId}")
    public String getByFileId(@PathVariable Integer fileId) {
        try {
            Optional<File> file = fileRepository.findById(fileId);
            byte[] content = file.get().getData();

            response.reset();
            response.setContentType(file.get().getType());
            response.setHeader("Content-Disposition", "attachment;filename=" + file.get().getName());

            BufferedOutputStream outStream = new BufferedOutputStream(response.getOutputStream());
            outStream.write(content);
            outStream.close();
            return "File downloaded successfully";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
