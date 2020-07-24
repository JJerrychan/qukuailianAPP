package com.cq.xinyupintai.data.model;

import com.contrarywind.interfaces.IPickerViewData;

import java.util.List;

public class CategoriesBean implements IPickerViewData {
    /**
     * name : 保健
     * Categories2 : [{"name":"洗浴","Categories3":["洗浴","足浴","汗蒸"]}]
     */
    private String name;
    private String catID;
    private List<Categories2Bean> Categories2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatID() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }

    public List<Categories2Bean> getCategories2() {
        return Categories2;
    }

    public void setCategories2(List<Categories2Bean> categories2) {
        this.Categories2 = categories2;
    }

    @Override
    public String getPickerViewText() {
        return name;
    }

    public static class Categories2Bean {
        /**
         * name : 洗浴
         * Categories3 : ["洗浴","足浴","汗蒸"]
         */
        private String name;
        private String catID;
        private List<Categories3> Categories3;

        public String getCatID() {
            return catID;
        }

        public void setCatID(String catID) {
            this.catID = catID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Categories3> getCategories3() {
            return Categories3;
        }

        public void setCategories3(List<Categories3> categories3) {
            this.Categories3 = categories3;
        }
    }

    public static class Categories3 {
        private String name;
        private String catID;

        public String getCatID() {
            return catID;
        }

        public void setCatID(String catID) {
            this.catID = catID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}



