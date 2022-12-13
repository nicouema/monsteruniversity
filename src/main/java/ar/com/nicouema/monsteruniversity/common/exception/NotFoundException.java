package ar.com.nicouema.monsteruniversity.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotFoundException extends RuntimeException{
    private final Object resourceId;
}
