package com.bilko.beer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BeerItems")
public class BeerItem {

        @Id
        private long id;
        
        private String uid;
        private String brand;
        private String name;
        private String style;
        private String hop;
        private String yeast;
        private String malts;
        private String ibu;
        private String alcohol;
        private String blg;
        
        public BeerItem(long id, String uid, String brand, String name, String style, String hop, String yeast, String malts, String ibu, String alcohol, String blg) {
            super();
            this.id = id;
            this.uid = uid;
            this.brand = brand;
            this.name = name;
            this.style = style;
            this.hop = hop;
            this.yeast = yeast;
            this.malts = malts;
            this.ibu = ibu;
            this.alcohol = alcohol;
            this.blg = blg;
        }
        public long getID() { return this.id; }
        public void setID(long id) { this.id = id; }
        
        public String getUID() { return this.uid; }
        public void setUID(String uid) { this.uid = uid; }
        
        public String getBrand() { return this.brand; }
        public void setBrand(String brand) { this.brand = brand; }
        
        public String getName() { return this.name; }
        public void setName(String name) { this.name = name; }
        
        public String getStyle() { return this.style; }
        public void setStyle(String style) { this.style = style; }
        
        public String getHop() { return this.hop; }
        public void setHop(String hop) { this.hop = hop; }
        
        public String getYeast() { return this.yeast; }
        public void setYeast(String yeast) { this.yeast = yeast; }
        
        public String getMalts() { return this.malts; }
        public void setMalts(String malts) { this.malts = malts; }
        
        public String getIbu() { return this.ibu; }
        public void setIbu(String ibu) { this.ibu = ibu; }
        
        public String getAlcohol() { return this.alcohol; }
        public void setAlcohol(String alcohol) { this.alcohol = alcohol; }
        
        public String getBlg() { return this.blg; }
        public void setBlg(String blg) { this.blg = blg; }
}