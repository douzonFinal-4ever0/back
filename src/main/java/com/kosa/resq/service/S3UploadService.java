package com.kosa.resq.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class S3UploadService {

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String saveFile(MultipartFile multipartFile, String title) throws IOException {
        String s3FileName = UUID.randomUUID() + "-" + title + "-" + multipartFile.getOriginalFilename();

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(multipartFile.getSize());
        metadata.setContentType(multipartFile.getContentType());

        amazonS3.putObject(bucket, s3FileName, multipartFile.getInputStream(), metadata);
        return amazonS3.getUrl(bucket, s3FileName).toString();
    }


//    public byte[] downloadImage(String originalFilename) throws IOException {
//        S3Object s3Object = amazonS3.getObject(bucket, originalFilename);
//        S3ObjectInputStream s3ObjectContent = s3Object.getObjectContent();
//        return IOUtils.toByteArray(s3ObjectContent);
//    }

}
