package com.example.actuatorservice.domain;

public class User implements Identifiable {
        private Long Userid;
        private String Emailaddress;
        private String Tag;

        public Long getId() {
            return Userid;
        }
        public void setId(Long Userid) {
            this.Userid = Userid;
        }
        public String getEmailaddress() {
            return Emailaddress;
        }
        public void setEmailaddress(String description) {
            this.Emailaddress = Emailaddress;
        }
        public void setTags(String tag) {
            this.Tag =Tag;
        }
        public String getTag() {
            return Tag;
       }


}


