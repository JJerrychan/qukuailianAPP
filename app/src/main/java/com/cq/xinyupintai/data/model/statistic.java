package com.cq.xinyupintai.data.model;

public class statistic {

        private String name;
        private String number;

        public statistic(String name, String number) {
            this.name = name;
            this.number = number;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public String getNumber() {
            return number;
        }

}
