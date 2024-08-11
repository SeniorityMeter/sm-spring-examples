package br.com.senioritymeter.storage.aws_s3;

import br.com.senioritymeter.storage.enumeration.StorageType;
import br.com.senioritymeter.storage.interaction.StorageCreation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CreateAwsS3Example {
    private final StorageCreation storageCreation;

    public void execute(MultipartFile file) throws IOException {
        String domain = "domain";
        String bucket = "os-file-manager";

        StorageCreation.Input input = StorageCreation.Input.builder()
            .bucket(bucket)
            .type(StorageType.AWS_S3)
            .domain(domain)
            .fileArray(file.getInputStream())
            .build();

        storageCreation.execute(input);
    }
}
