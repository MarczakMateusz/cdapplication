package pl.dominisz.Menu;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MenuItem {
    private String message;
    private Runnable action;

}
