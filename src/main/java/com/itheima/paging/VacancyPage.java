package com.itheima.paging;



import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class VacancyPage implements Serializable {

    private List<Map<String, Object>> mapList;
    private Page page;


    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<Map<String, Object>> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map<String, Object>> mapList) {
        this.mapList = mapList;
    }

    @Override
    public String toString() {
        return "VacancyPage{" +
                "mapList=" + mapList +
                ", page=" + page +
                '}';
    }
}

