package cc.jktu.apps.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
public record CommonResp<T>(Date timestamp, Integer status, String message, String path, T data) {

    public static final String DEFAULT_MESSAGE = "No message available";

    public static <T> CommonResp<T> ok(T data) {
        return of(HttpStatus.OK, data, DEFAULT_MESSAGE);
    }

    public static CommonResp<Void> empty() {
        return of(HttpStatus.OK, null, DEFAULT_MESSAGE);
    }

    public static CommonResp<Void> emptyWithMsg(String message) {
        return of(HttpStatus.OK, null, message);
    }

    public static <T> CommonResp<T> of(HttpStatus status, T data, String message) {
        String path = null;
        try {
            path = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRequestURI();
        } catch (IllegalStateException e) {
            log.warn(e.getLocalizedMessage());
        }
        return new CommonResp<>(new Date(), status.value(), message, path, data);
    }

}
