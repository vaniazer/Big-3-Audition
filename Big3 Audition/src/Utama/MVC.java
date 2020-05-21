package Utama;

import Controller_Pack.*;
import View_Pack.*;

public class MVC {
    public MVC(){
        vLogin vLogin = new vLogin();
        Model model = new Model();
        Controller controller = new Controller(vLogin,model);
    }
}
