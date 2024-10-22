package im.greenery.simple.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SimpleRes {

    private Integer id;
    
    private String name;

    private String email;

    private String phone;

}
