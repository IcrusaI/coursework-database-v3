package org.example;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "config")
public class Config {
    @JacksonXmlProperty(isAttribute = false, localName = "tables")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<Table> tables;


    @JacksonXmlProperty(isAttribute = false, localName = "tableName")
    public String tableName;

    public Config() {}

    public Config(List<Table> tables) {
        this.tables = tables;
    }

    public List<Table> getTables() {
        return this.tables;
    }
    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public String getTableName() {
        return this.tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}

