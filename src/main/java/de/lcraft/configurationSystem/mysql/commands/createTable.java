package de.lcraft.configurationSystem.mysql.commands;

import de.lcraft.configurationSystem.mysql.Command;
import de.lcraft.configurationSystem.mysql.MySQLDataBase;
import de.lcraft.configurationSystem.mysql.MySQLServer;
import java.util.ArrayList;

public class createTable implements Command {

    private String name;
    private ArrayList<String[]> data;

    public createTable(String name) {
        setName(name);
        setData(new ArrayList<>());
    }
    public void addColumn(String id, String type) {
        setColumn(data.size(), id, type);
    }
    public void setColumn(int index, String id, String type) {
        getData().set(index, new String[]{id, type});
    }

    @Override
    public String createSQL(MySQLDataBase mySQLDataBase) {
        String sql = "CREATE TABLE " + getName() + " (";

        for(String[] c : getData()) {
            String id = c[0];
            String type = c[1];

            sql = sql + id + " " + type + ",";
        }

        return MySQLServer.replaceEnd(sql, ",", "") + ")";
    }

    public String getName() {
        return name;
    }
    public ArrayList<String[]> getData() {
        return data;
    }

    private void setName(String name) {
        this.name = name;
    }
    private void setData(ArrayList<String[]> data) {
        this.data = data;
    }

}
