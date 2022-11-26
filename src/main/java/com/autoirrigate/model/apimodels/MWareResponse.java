package com.autoirrigate.model.apimodels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Slf4j
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MWareResponse {
    private String status;
    private String message;
    private Map<String, Object> payload;

    @JsonIgnore
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private ObjectMapper mapper = new ObjectMapper();

    public Object getPayloadObject(String key) {
        if (payload != null && payload.containsKey(key)) {
            return payload.get(key);
        }
        return null;
    }

    public <T> T getPayloadValue(String key, Class<T> type) {
        if (payload != null && payload.containsKey(key)) {
            return (T) payload.get(key);
        }
        return null;
    }

    public String getMessage(List<String> values) {
        return getMessage(values, true);
    }

    public String getMessage(List<String> values, boolean getDefault) {
        String respMessage = "";

        if (payload != null && values != null && values.size() > 0) {
            for (String tagKey : values) {
                Object retObj = payload.get(tagKey);
                if (retObj != null && retObj instanceof String) {
                    log.info(">> matched {} : {}", tagKey, respMessage);
                    break;
                }
            }
        }

        if (getDefault && StringUtils.isEmpty(respMessage))
            respMessage = message;

        return respMessage;
    }

}