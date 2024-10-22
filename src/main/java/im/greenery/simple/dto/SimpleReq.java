package im.greenery.simple.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleReq { 

    private String name;
    
    private String email;
    
    private String phone;
}
