package uz.agromon.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FailureMessage {
    private String exceptionName;
    private String exceptionMessage;
    private String exceptionCode;
}
