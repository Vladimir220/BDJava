package bdjava.lab3.var4;

import java.util.ArrayList;
import java.util.HashMap;

/*
6. Система Конструкторское бюро. Заказчик представляет Техническое Задание (ТЗ) на проектирование многоэтажного Дома.
Конструктор регистрирует ТЗ, определяет стоимость проектирования и строительства, выставляет Заказчику Счет за
проектирование и создает Бригаду Конструкторов для выполнения Проекта.
 */
public class Part1 {
    public static void main(String[] args) {

    }
}

class DesignDepartment {
    Designer chiefDesigner;
    ArrayList<Designer> freeDesigners;
    ArrayList<Designer> busyDesigners;
    HashMap<String, String> technicalTask;
    RegisterOfTechnicalTask regTT;

    DesignDepartment () {

    }
    DesignDepartment (HashMap<String, String> TT) {

    }
    public void loadTT () {

    }
    public void toRegTT () {

    }

}

class Building {

}

class Designer {

}

class chiefDesigner {
    
}

class RegisterOfTechnicalTask {

}