package pl.payment.main.domain.service.errorcodeinfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.payment.main.infrastructure.config.errorcode.ErrorCode;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ErrorCodeInfoService {

    @Autowired
    ObjectMapper objectMapper;

    public List<String> getAllErrors() {
        List<String> parsedEnums = new ArrayList<String>();
        for (ErrorCode code :
                ErrorCode.values()) {
            try {
                parsedEnums.add(objectMapper.writeValueAsString(code));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return parsedEnums;
    }
}
