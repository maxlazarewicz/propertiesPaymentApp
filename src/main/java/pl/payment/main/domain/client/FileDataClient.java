package pl.payment.main.domain.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.payment.main.infrastructure.config.ClientConfig;

import java.util.List;

@FeignClient(value = "filedata", url = "${client.filedata.url}",
        configuration = ClientConfig.class)
public interface FileDataClient {

    @RequestMapping(method = RequestMethod.GET,
            value = "/filedata/list", produces = "application/json")
    List<FileData> getFileData();

    @RequestMapping(method = RequestMethod.POST,
            value = "/filedata/add", produces = "application/json")
    FileData addFileData(FileData fileData);
}


