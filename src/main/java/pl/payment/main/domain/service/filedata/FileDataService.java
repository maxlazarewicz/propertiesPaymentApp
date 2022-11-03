package pl.payment.main.domain.service.filedata;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.payment.main.domain.client.FileData;
import pl.payment.main.domain.client.FileDataClient;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class FileDataService {

    @Autowired
    FileDataClient fileDataClient;

    @Transactional
    public void addFilesFromList(List<FileData> fileDataList){
        fileDataList.stream().forEach(f->
                fileDataClient.addFileData(f)
                );
    }

}
