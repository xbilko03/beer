package com.bilko.beer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Reviews")
public class ReviewItem {

        /* this id is also the ID of a particular beer */
        @Id
        private long id;

        private long rating;
        private String text;
        
        public ReviewItem(long id, long rating, String text) {
            super();
            this.id = id;
            this.rating = rating;
            this.text = text;
        }
        public long getID() { return this.id; }
        public void setID(long id) { this.id = id; }
        
        public long getRating() { return this.rating; }
        public void setRating(long rating) { this.rating = rating; }
        
        public String getText() { return this.text; }
        public void setText(String text) { this.text = text; }
}