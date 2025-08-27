package mvc;

import mvc.view.Visual;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Visual visual= new Visual();
        visual.view();
    }
}